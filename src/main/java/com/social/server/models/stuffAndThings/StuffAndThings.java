package com.social.server.models.stuffAndThings;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StuffAndThings {

    private String[] catering;
    private String[] takeThisWithYou;
    private String[] physicalExertion;
    private String[] mentalExertion;
    private String[] emotinaolExertion;
    private String[] languageRestriction;
}