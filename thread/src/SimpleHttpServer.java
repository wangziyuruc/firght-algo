import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * chapter 4-21
 * @author xuanyu
 */
public class SimpleHttpServer {

    // SimpleHttpServer 根路径
    private static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;

    public static void setPort(int port){
        if(port>0){
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath){
        if(basePath !=null&&new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }


    static class HttpRequestHandler implements Runnable{
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }



        @Override
        public void run() {
            String line =null;
            BufferedReader br = null;
            BufferedReader reader =null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                // 由相对路由计算绝对路由
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                // 如果请求资源的后缀为jpg 或者ico 读取资源并输出
                if(filePath.endsWith("jpg")||filePath.endsWith("ico")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i=0;
                    while ((i=in.read()) !=-1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpg");
                    out.println("Content-Length: "+array.length);
                    out.println("");
                    socket.getOutputStream().write(array,0,array.length);
                }else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath )));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset-UTF-8");
                    out.println("");
                    while ((line=br.readLine()) !=null){
                        out.println(line);
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                close(br,in,reader,out,socket);
            }
        }
    }

    private static void close(Closeable... closeables){
        if(closeables !=null){
            for (Closeable closeable : closeables){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;

    }
}
