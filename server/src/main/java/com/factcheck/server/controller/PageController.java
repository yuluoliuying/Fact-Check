package com.factcheck.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @GetMapping("index")
    public String index() {
        return "front/index";
    }

    @GetMapping("index.html")
    public String index2() {
        return "front/index";
    }

    @GetMapping("news")
    public String news() {
        return "front/news";
    }

    @GetMapping("news.html")
    public String news2() {
        return "front/news";
    }

    @GetMapping("news/{rid}")
    public String news3(@PathVariable Integer rid) {return "front/news";}

    @GetMapping("submit")
    public String submit() {
        return "front/submit";
    }

    @GetMapping("submit.html")
    public String submit2() {
        return "front/submit";
    }

    @GetMapping("login")
    public String login() {
        return "back/login";
    }

    @GetMapping("login.html")
    public String login2() {
        return "back/login";
    }

    @GetMapping("check")
    public String check() {
        return "back/check";
    }

    @GetMapping("check.html")
    public String check2() {
        return "back/check";
    }

    @GetMapping("checkedf")
    public String checkedf() {
        return "back/checkedf";
    }

    @GetMapping("checkedf.html")
    public String checkedf2() {
        return "back/checkedf";
    }

    @GetMapping("checkeds")
    public String checkeds() {
        return "back/checkeds";
    }

    @GetMapping("checkeds.html")
    public String checkeds2() {
        return "back/checkeds";
    }

    @GetMapping("distribute")
    public String distribute() {
        return "back/distribute";
    }

    @GetMapping("distribute.html")
    public String distribute2() {
        return "back/distribute";
    }

    @GetMapping("tobechecked")
    public String tobechecked() {
        return "back/tobechecked";
    }

    @GetMapping("tobechecked.html")
    public String tobechecked2() {
        return "back/tobechecked";
    }

    @GetMapping("tobedrafted")
    public String tobedrafted() {
        return "back/tobedrafted";
    }

    @GetMapping("tobedrafted.html")
    public String tobedrafted2() {
        return "back/tobedrafted";
    }
}
