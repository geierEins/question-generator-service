package de.geier.QuestionGeneratorService.questions;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class QuestionInhabitants extends Question {

	String body2;

	public QuestionInhabitants(String candidate, long correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "";
		body = "Wieviele Einwohner hat ";
		body2 = " (Stand: 2021)";
		if(isMillion(correctAnswer)) {
			this.correctAnswer=translateNumberTest(correctAnswer);
			setMioUnit();
		}
	}

	@Override
	public String questionToString() {
		return body + candidate + "?" + unit + body2;
	}
	
	private float translateNumberTest(long numberToTranslate) {
		BigDecimal bdInput = new BigDecimal(numberToTranslate);
		BigDecimal bdDiv = bdInput.divide(new BigDecimal(1000000));
		float f = bdDiv.floatValue();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setMaximumFractionDigits(2);
		String trimmedValue = decimalFormat.format(f);
		trimmedValue = trimmedValue.replace(",", ".");
		return Float.parseFloat(trimmedValue);
	}
	
	private boolean isMillion(long numberToTranslate) {
		return (numberToTranslate > 999999L && numberToTranslate <= 999999999L);
	}
	
	private void setMioUnit() {
		this.unit=" (in Millionen)";
	}
}