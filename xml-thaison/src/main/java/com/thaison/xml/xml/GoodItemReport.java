package com.thaison.xml.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "GoodItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoodItemReport {

	@XmlElement(name = "FieldNo")
	private String fieldNo;

	@XmlElement(name = "HSCode")
	private String hsCode;

	@XmlElement(name = "MaterialCode")
	private String materialCode;

	@XmlElement(name = "PriceReconfirmingClassification")
	private String priceReconfirmingClassification;

	@XmlElement(name = "ItemCode")
	private String itemCode;

	@XmlElement(name = "ItemName")
	private String itemName;

	@XmlElement(name = "Quantity1")
	private String quantity1;

	@XmlElement(name = "QuantityUnitCode")
	private String quantityUnitCode;

	@XmlElement(name = "Quantity2")
	private String quantity2;

	@XmlElement(name = "QuantityUnitCode2")
	private String quantityUnitCode2;

	@XmlElement(name = "InvoiceValue")
	private String invoiceValue;

	@XmlElement(name = "InvoiceUnitPrice")
	private String invoiceUnitPrice;

	@XmlElement(name = "UnitPriceCurrencyCode")
	private String unitPriceCurrencyCode;

	@XmlElement(name = "PriceQuantityUnit")
	private String priceQuantityUnit;

	@XmlElement(name = "CustomsValueS")
	private String customsValueS;

	@XmlElement(name = "CustomsValueCurrencyCode")
	private String customsValueCurrencyCode;

	@XmlElement(name = "TaxValueCurrencyCode")
	private String taxValueCurrencyCode;

	@XmlElement(name = "TaxValueM")
	private String taxValueM;

	@XmlElement(name = "CustomsStandardQuantity")
	private String customsStandardQuantity;

	@XmlElement(name = "MeasureUnitCodeQuantity")
	private String measureUnitCodeQuantity;

	@XmlElement(name = "CustomsValueUnitPrice")
	private String customsValueUnitPrice;

	@XmlElement(name = "CustomsUnitPriceCurrency")
	private String customsUnitPriceCurrency;

	@XmlElement(name = "QuantityUnitOfCustoms")
	private String quantityUnitOfCustoms;

	@XmlElement(name = "EmportTaxRate")
	private String emportTaxRate;

	@XmlElement(name = "EmportTaxRateClassification")
	private String emportTaxRateClassification;

	@XmlElement(name = "ExportTaxAmount")
	private String exportTaxAmount;

	@XmlElement(name = "ExportTaxAmountCurrencyCode")
	private String exportTaxAmountCurrencyCode;

	@XmlElement(name = "ExemptionReductionAmount")
	private String exemptionReductionAmount;

	@XmlElement(name = "ExemptionReductionAmountCurrency")
	private String exemptionReductionAmountCurrency;

	@XmlElement(name = "CorrespondedLineNumberTentative")
	private String correspondedLineNumberTentative;

	@XmlElement(name = "TaxExemptionListNo")
	private String taxExemptionListNo;

	@XmlElement(name = "TargetLineNumber")
	private String targetLineNumber;

	@XmlElement(name = "CommissionUnitPrice")
	private String commissionUnitPrice;

	@XmlElement(name = "InsuranceUnitPrice")
	private String insuranceUnitPrice;

	@XmlElement(name = "CommissionQuantity")
	private String commissionQuantity;

	@XmlElement(name = "CommissionQuantityUnitCode")
	private String commissionQuantityUnitCode;

	@XmlElement(name = "InsuranceQuantity")
	private String insuranceQuantity;

	@XmlElement(name = "InsuranceQuantityUnitCode")
	private String insuranceQuantityUnitCode;

	@XmlElement(name = "CommissionAmount")
	private String commissionAmount;

	@XmlElement(name = "InsuranceAmount")
	private String insuranceAmount;

	@XmlElement(name = "OtherLawCode")
	private String otherLawCode;

	@XmlElement(name = "OtherLawCode2")
	private String otherLawCode2;

	@XmlElement(name = "OtherLawCode3")
	private String otherLawCode3;

	@XmlElement(name = "OtherLawCode4")
	private String otherLawCode4;

	@XmlElement(name = "OtherLawCode5")
	private String otherLawCode5;

	@XmlElement(name = "ExemptionReductionCodeExportTax")
	private String exemptionReductionCodeExportTax;

	@XmlElement(name = "TariffExemptionReductionArticle")
	private String tariffExemptionReductionArticle;

}
