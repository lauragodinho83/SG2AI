package helper;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.*;

public final class AreaDeTransferencia implements ClipboardOwner {

    @Override
    public void lostOwnership( Clipboard clipboard, Transferable contents ) {
        
    }
    
    public void setClipboardContents( String texto ) {
        StringSelection stringSelection = new StringSelection( texto );
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        clipboard.setContents( stringSelection, this );
    }
    
    public String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents( this );
        
        boolean hasTransferableText = ( contents != null ) && contents.isDataFlavorSupported( DataFlavor.stringFlavor );
        
        if( hasTransferableText ) {
            try {
                result = ( String ) contents.getTransferData( DataFlavor.stringFlavor );
            }
            catch( UnsupportedFlavorException | IOException ex ) {
                System.out.println( ex );
                ex.printStackTrace();
            }
        }
        
        return result;
    }
}
