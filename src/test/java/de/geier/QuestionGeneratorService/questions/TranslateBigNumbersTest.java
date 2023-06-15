package de.geier.QuestionGeneratorService.questions;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

public class TranslateBigNumbersTest {

	long bigNumber = 3640880L;
	long bigNumber2 = 23640880L;
	long bigNumber3 = 123640880L;

	@Test
	public void callTests() {
		translateNumberTest(bigNumber);
		translateNumberTest(bigNumber2);
		translateNumberTest(bigNumber3);
	}

	public void translateNumberTest(long numberToTranslate) {
		if (numberToTranslate > 999999L) {
			if (numberToTranslate <= 999999999L) {
				BigDecimal bdInput = new BigDecimal(numberToTranslate);
				BigDecimal bdDiv = bdInput.divide(new BigDecimal(1000000));
				float f = bdDiv.floatValue();
				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				decimalFormat.setMaximumFractionDigits(2);
				String trimmedValue = decimalFormat.format(f);
				trimmedValue = trimmedValue.replace(",", ".");
				float fResult = Float.parseFloat(trimmedValue);
				System.out.println(fResult);
			}
		}
	}
}
