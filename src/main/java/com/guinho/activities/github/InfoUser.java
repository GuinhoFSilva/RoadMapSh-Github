package com.guinho.activities.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoUser {
    @JsonProperty("type")
    private String type;
    private Integer qtd;
    @JsonProperty("actor")
    private Actor actor;
    @JsonProperty("repo")
    private Repo repo;


    public InfoUser(String type, Actor actor, Repo repo) {
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.qtd = 0;
    }

    public InfoUser() {
        this.qtd = 0;
    }

    public static class Actor{
        @JsonProperty("id")
        private Long id;
        @JsonProperty("login")
        private String login;

        public Actor(){}

        public Actor(Long id, String login) {
            this.id = id;
            this.login = login;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        @Override
        public String toString() {
            return "Actor{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    '}';
        }
    }

    public static class Repo{
        @JsonProperty("id")
        private Long id;
        @JsonProperty("name")
        private String name;

        public Repo(){}

        public Repo(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Repo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    @Override
    public String toString() {
        return "InfoUser{" +
                "type='" + type + '\'' +
                ", qtd=" + qtd +
                ", actor=" + actor +
                ", repo=" + repo +
                '}';
    }
}
