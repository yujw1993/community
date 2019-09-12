package life.wind.community.controller;

import life.wind.community.dto.AccessTokenDto;
import life.wind.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeConntroller {

    @Autowired
    private GitHubProvider gitHubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDto.setCient_id("05b939adb2f5e7bf6c7d");
        accessTokenDto.setClient_secret("d7c9e2d84652d07046e6e78e8d5433a60668a2e3");
        gitHubProvider.getAccesstoken(accessTokenDto);

        return "index";
    }
}
