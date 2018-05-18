package demo.jili;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

/**
 * send text
 * @author klay
 *
 */

public class DemoJ_One {
    public static String requestUrl = "https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg";
    public static String cookie  = "";

    public static void sendMsg(String requestUrl,String cookie){
        String url = "https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg";//请求链接
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader(new BasicHeader("cookie", cookie)); //其实cookie可以不设置，也能发送
        Long currentTimeMillis = System.currentTimeMillis();
        String requestParam = "{\"BaseRequest\":{\"Uin\":You id,\"Sid\":\"EwwSa9Jb1fSGjQW1\",\"Skey\":\"@crypt_c799f4fc_7f98126a5836d9ed6fdbff40cd491c5f\",\"DeviceID\":\"e155964836553096\"},\"Msg\":{\"Type\":1,\"Content\":\"hello.J\",\"FromUserName\":\"@123\",\"ToUserName\":\"123\",\"LocalID\":\""+currentTimeMillis+"\",\"ClientMsgId\":\""+currentTimeMillis+"\"}}";
        try {
            StringEntity s = new StringEntity(requestParam);
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMsg(requestUrl,cookie);
    }

}
