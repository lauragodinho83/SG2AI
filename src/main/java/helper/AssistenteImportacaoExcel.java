package helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class AssistenteImportacaoExcel implements Serializable {
    
    private String destino = "/tmp/upload/";
    private UploadedFile arquivo;

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public void upload() {
        
        System.out.println( arquivo.getFileName() );
        
        if( arquivo != null ) {
            Mensagem.sucesso();
        }
        else {
            Mensagem.erro( "Upload falhou" );
        }
    }
    
    public void copiarArquivo( String fileName, InputStream in ) {
        try {
            OutputStream out = new FileOutputStream( new File( destino + fileName ) );
            
            int read = 0;
            byte[] bytes = new byte[ 102400 ];
            
            while( ( read = in.read( bytes ) ) != -1 ) {
                out.write( bytes, 0, read );
            }
            
            in.close();
            out.flush();
            out.close();
            
            System.out.println( "Novo arquivo criado!" );
        }
        catch( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }
}