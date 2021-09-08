package org.home.demoauthentication.challenges.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Challenge {
    private long id;
    private String title;
    private String description;
    private long credits;

    public  Challenge(){}

    public Challenge(final long id, final String title, final String description, final long credits) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.credits = credits;
    }

    public Challenge(final String title, final long credits) {
        this.title = title;
        this.credits = credits;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Challenge challenge = (Challenge) o;
        return this.id == challenge.id &&
                this.credits == challenge.credits &&
                Objects.equals(this.title, challenge.title) &&
                Objects.equals(this.description, challenge.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.description, this.credits);
    }

}

