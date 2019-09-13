package life.wind.community.provider;

import com.alibaba.fastjson.JSON;
import life.wind.community.dto.AccessTokenDto;
import life.wind.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    public String getAccesstoken(AccessTokenDto accessTokenDto){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();


            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDto));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String  access_token= string.split("&")[0].split("=")[1];
                return access_token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  null;

    }

    public GitHubUser getUser(String access_token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+access_token)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }
}
