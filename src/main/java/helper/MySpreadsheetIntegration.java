package helper;

import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;
import controller.QuestaoEJB;

import java.io.IOException;
import java.net.*;
import java.util.*;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Questao;

@ManagedBean(name = "googleDocs")
@ViewScoped
public class MySpreadsheetIntegration implements Serializable {
    
    private String username;
    private String password;
    private String planilha;
    private SpreadsheetService servico;
    private SpreadsheetEntry planilhaDocs;
    private URL url;
    
    @EJB
    private QuestaoEJB questaoController;
    
    public MySpreadsheetIntegration() throws MalformedURLException {
        url = new URL( "https://spreadsheets.google.com/feeds/spreadsheets/private/full" );
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlanilha() {
        return planilha;
    }

    public void setPlanilha(String planilha) {
        this.planilha = planilha;
    }
    
    public List<String> obterTitulosDasPlanilhas()
            throws AuthenticationException, MalformedURLException, IOException, ServiceException {
        
        autenticarServico();
        List<SpreadsheetEntry> spreadsheets = obterPlanilhas();
        
        if( spreadsheets.isEmpty() ) {
            return new ArrayList<>();
        }
        
        List<String> lista = new ArrayList<>();
        
        for( SpreadsheetEntry spreadsheet : spreadsheets ) {
            lista.add( spreadsheet.getTitle().getPlainText() );
        }
        
        return lista;
    }
    
    public void finalizar() throws ServiceException, IOException {
        List<SpreadsheetEntry> spreadsheets = obterPlanilhas();
        
        for( SpreadsheetEntry spreadsheet : spreadsheets ) {
            if( spreadsheet.getTitle().getPlainText().equals( planilha ) ) {
                planilhaDocs = spreadsheet;
            }
        }
        
        WorksheetEntry worksheet = selecionarWorksheet();
        ListFeed listFeed = obterListFeed( worksheet );
        
        for( ListEntry linha : listFeed.getEntries() ) {
            
            String veracidade = linha.getCustomElements().getValue( "veracidade" );
            String descricao  = linha.getCustomElements().getValue( "descrição" );
            Questao questao = new Questao();
            
            if( veracidade.startsWith( "V" ) ) {
                questao.setVeracidade( true );
            }
            else {
                questao.setVeracidade( false );
            }
            
            if( !descricao.isEmpty() ) {
                questao.setEnunciado( descricao );
            }
            else {
                questao.setEnunciado( "Qual a resposta para a vida, o universo e tudo o mais?" );
            }
            
            questaoController.salvar( questao );
            
            Mensagem.sucesso();
        }
    }
    
    public ListFeed obterListFeed( WorksheetEntry worksheet ) throws IOException, ServiceException {
        URL listFeedUrl = worksheet.getListFeedUrl();
        return servico.getFeed( listFeedUrl, ListFeed.class );
    }
    
    public WorksheetEntry selecionarWorksheet() throws IOException, ServiceException {
        if( planilhaDocs == null ) {
            Mensagem.erro( "Nenhuma planilha foi selecionada." );
            return null;
        }
        
        WorksheetFeed worksheetFeed = servico.getFeed( planilhaDocs.getWorksheetFeedUrl(), WorksheetFeed.class );
        List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
        
        return worksheets.get( 0 );
    }
    
    public List<SpreadsheetEntry> obterPlanilhas() throws ServiceException, IOException {
        SpreadsheetFeed feed = servico.getFeed( url, SpreadsheetFeed.class );
        return feed.getEntries();
    }
    
    public void autenticarServico() throws AuthenticationException {
        servico = new SpreadsheetService( "SG2AI.System" );
        
        servico.setUserCredentials( username, password );
    }
}
