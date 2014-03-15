package com.voxworx.polycom;

/**
 * The answer modes available for ring classes (i.e. se.rt.classname.type)
 * @author Ian
 *
 */
public enum AnswerMode {

	RING("ring"),
	VISUAL("visual"),
	ANSWER("answer"),
	RINGANSWER("ring-answer");
	
	private final String answerModeType;

	public String getAnswerModeType() {
		return answerModeType;
	}

	private AnswerMode(String answerModeType) {
		this.answerModeType = answerModeType;
	}
	
}
