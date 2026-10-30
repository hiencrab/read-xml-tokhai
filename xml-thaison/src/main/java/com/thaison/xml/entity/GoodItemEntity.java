package com.thaison.xml.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.thaison.xml.entity.BaseEntityJpa;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "public", name = "GOOD_ITEM")
public class GoodItemEntity extends BaseEntityJpa {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "DECLARATION_REPORT_ID")
    private Long declarationReportId;

    @Column(name = "FIELD_NO")
    private String fieldNo;

    @Column(name = "HS_CODE")
    private String hsCode;

    @Column(name = "MATERIAL_CODE")
    private String materialCode;

    @Column(name = "PRICE_RECONFIRMING_CLASSIFICATION")
    private String priceReconfirmingClassification;

    @Column(name = "ITEM_CODE")
    private String itemCode;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "QUANTITY_1")
    private String quantity1;

    @Column(name = "QUANTITY_UNIT_CODE")
    private String quantityUnitCode;

    @Column(name = "QUANTITY_2")
    private String quantity2;

    @Column(name = "QUANTITY_UNIT_CODE_2")
    private String quantityUnitCode2;

    @Column(name = "INVOICE_VALUE")
    private String invoiceValue;

    @Column(name = "INVOICE_UNIT_PRICE")
    private String invoiceUnitPrice;

    @Column(name = "UNIT_PRICE_CURRENCY_CODE")
    private String unitPriceCurrencyCode;

    @Column(name = "PRICE_QUANTITY_UNIT")
    private String priceQuantityUnit;

    @Column(name = "CUSTOMS_VALUE_S")
    private String customsValueS;

    @Column(name = "CUSTOMS_VALUE_CURRENCY_CODE")
    private String customsValueCurrencyCode;

    @Column(name = "TAX_VALUE_CURRENCY_CODE")
    private String taxValueCurrencyCode;

    @Column(name = "TAX_VALUE_M")
    private String taxValueM;

    @Column(name = "CUSTOMS_STANDARD_QUANTITY")
    private String customsStandardQuantity;

    @Column(name = "MEASURE_UNIT_CODE_QUANTITY")
    private String measureUnitCodeQuantity;

    @Column(name = "CUSTOMS_VALUE_UNIT_PRICE")
    private String customsValueUnitPrice;

    @Column(name = "CUSTOMS_UNIT_PRICE_CURRENCY")
    private String customsUnitPriceCurrency;

    @Column(name = "QUANTITY_UNIT_OF_CUSTOMS")
    private String quantityUnitOfCustoms;

    @Column(name = "EXPORT_TAX_RATE")
    private String emportTaxRate;

    @Column(name = "EXPORT_TAX_RATE_CLASSIFICATION")
    private String emportTaxRateClassification;

    @Column(name = "EXPORT_TAX_AMOUNT")
    private String exportTaxAmount;

    @Column(name = "EXPORT_TAX_AMOUNT_CURRENCY_CODE")
    private String exportTaxAmountCurrencyCode;

    @Column(name = "EXEMPTION_REDUCTION_AMOUNT")
    private String exemptionReductionAmount;

    @Column(name = "EXEMPTION_REDUCTION_AMOUNT_CURRENCY")
    private String exemptionReductionAmountCurrency;

    @Column(name = "CORRESPONDED_LINE_NUMBER_TENTATIVE")
    private String correspondedLineNumberTentative;

    @Column(name = "TAX_EXEMPTION_LIST_NO")
    private String taxExemptionListNo;

    @Column(name = "TARGET_LINE_NUMBER")
    private String targetLineNumber;

    @Column(name = "COMMISSION_UNIT_PRICE")
    private String commissionUnitPrice;

    @Column(name = "INSURANCE_UNIT_PRICE")
    private String insuranceUnitPrice;

    @Column(name = "COMMISSION_QUANTITY")
    private String commissionQuantity;

    @Column(name = "COMMISSION_QUANTITY_UNIT_CODE")
    private String commissionQuantityUnitCode;

    @Column(name = "INSURANCE_QUANTITY")
    private String insuranceQuantity;

    @Column(name = "INSURANCE_QUANTITY_UNIT_CODE")
    private String insuranceQuantityUnitCode;

    @Column(name = "COMMISSION_AMOUNT")
    private String commissionAmount;

    @Column(name = "INSURANCE_AMOUNT")
    private String insuranceAmount;

    @Column(name = "OTHER_LAW_CODE")
    private String otherLawCode;

    @Column(name = "OTHER_LAW_CODE_2")
    private String otherLawCode2;

    @Column(name = "OTHER_LAW_CODE_3")
    private String otherLawCode3;

    @Column(name = "OTHER_LAW_CODE_4")
    private String otherLawCode4;

    @Column(name = "OTHER_LAW_CODE_5")
    private String otherLawCode5;

    @Column(name = "EXEMPTION_REDUCTION_CODE_EXPORT_TAX")
    private String exemptionReductionCodeExportTax;

    @Column(name = "TARIFF_EXEMPTION_REDUCTION_ARTICLE")
    private String tariffExemptionReductionArticle;

}
