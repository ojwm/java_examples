package learningjava.protocolhandlers.crypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

import learningjava.protocolhandlers.crypt.CryptInputStream;

//file: CryptURLConnection.java
public class CryptURLConnection extends URLConnection {
    static int defaultPort = 80;
    CryptInputStream cis;

    public String getContentType(  ) {
        return guessContentTypeFromName( url.getFile(  ) );
    }

    public CryptURLConnection ( URL url, String crypType )
      throws IOException {
        super( url );
        try {
            String classname = "learningjava.protocolhandlers.crypt."
                + crypType + "CryptInputStream";
            cis = (CryptInputStream)
                   Class.forName(classname).newInstance(  );
        } catch ( Exception e ) {
            throw new IOException("Crypt Class Not Found: "+e);
        }
    }

    public void connect(  ) throws IOException {
        int port = ( url.getPort(  ) == -1 ) ?
                     defaultPort : url.getPort(  );
        Socket s = new Socket( url.getHost(  ), port );

        // Send the filename in plaintext
        OutputStream server = s.getOutputStream(  );
        new PrintWriter( new OutputStreamWriter( server, "8859_1" ),
                         true).println( "GET " + url.getFile(  ) );

        // Initialize the CryptInputStream
        cis.set( s.getInputStream(  ), server );
        connected = true;
    }

    public InputStream getInputStream(  ) throws IOException {
        if (!connected)
            connect(  );
        return ( cis );
    }
}
