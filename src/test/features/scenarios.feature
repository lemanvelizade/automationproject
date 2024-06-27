@test
Feature: Otomasyon

  @test
  Scenario: kredi hesaplama
    Given Open the "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" URL
    Then I wait for 2 seconds
    When I click the "TuketiciKredisi" element
    Then I enter "5000000" into the "tutar" field
    Then I enter "36" into the "vade" field
    Then I enter "5" into the "faizOrani" field
    When I click the "Hesapla" element
    Then I wait for 5 seconds
    Then I wait result


  Scenario: mevduat getirisi hesaplama
    Given Open the "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" URL
    Then I wait for 2 seconds
    When I click the "MevduatGetirisiHesaplama" element
    Then I enter "12" into the "mevduatVade" field
    Then I enter "100000" into the "mevduatTutar" field
    Then I click the "Hesapla" element
    Then I wait for 5 seconds
    Then I wait result

  Scenario: IBAN hesaplama
    Given Open the "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" URL
    Then I wait for 2 seconds
    When I click the "IBANHesaplama" element
    Then I enter "11111111" into the "musteriNo" field
    Then I enter "2222" into the "ekNo" field
    Then I click the "Hesapla" element
    Then I wait for 5 seconds
    Then I wait result
