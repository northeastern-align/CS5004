/**
 * This class represents a stock. A stock includes: name of company, ticker, price per unit share,
 * lowest annual price, highest annual price, total debts, total assets, and an analyst
 * recommendation.
 */

public class Stock {

  private String company;
  private String ticker;
  private float ppus;
  private float yearLow;
  private float yearHigh;
  private float debts;
  private float assets;
  private int recommendation;

  /**
   * Construct a Stock object that has provided attributes name of company, ticker, price per unit
   * share, lowest annual price, highest annual price, total debts, total assets, and an analyst
   * recommendation.
   *
   * @param company the name of the company
   * @param ticker the ticker abbreviation of the company
   * @param ppus the price per unit share
   * @param yearLow the lowest share price the last 52 weeks
   * @param yearHigh the highest share price the last 52 weeks
   * @param debts the total debts in dollar value
   * @param assets the total assets in dollar value
   * @param recommendation a analyst rating 1 (sell) - 5 (buy)
   */

  public Stock(String company, String ticker, float ppus, float yearLow, float yearHigh,
      float debts, float assets, int recommendation) {
    this.company = company;
    this.ticker = ticker;
    this.ppus = ppus;
    this.yearLow = yearLow;
    this.yearHigh = yearHigh;
    this.debts = debts;
    this.assets = assets;
    this.recommendation = recommendation;
  }

  /**
   * Returns the company name.
   *
   * @return the company name
   */
  public String getCompany() {
    return this.company;
  }

  /**
   * Returns the ticker of the company.
   *
   * @return the ticker of the company
   */
  public String getTicker() {
    return this.ticker;
  }

  /**
   * Returns price per unit share of the company.
   *
   * @return the price per unit share of the company
   */
  public float getPpus() {
    return this.ppus;
  }

  /**
   * Returns the lowest stock price the last 52 weeks.
   *
   * @return the lowest stock price during the last 52 weeks
   */
  public float getYearLow() {
    return this.yearLow;
  }

  /**
   * Returns the highest stock price the last 52 weeks.
   *
   * @return the highest stock price during the last 52 weeks
   */
  public float getYearHigh() {
    return this.yearHigh;
  }

  /**
   * Returns the total accumulated debts.
   *
   * @return the total accumulated debts
   */
  public float getDebts() {
    return this.debts;
  }

  /**
   * Returns the total accumulated assets.
   *
   * @return the total accumulated assets
   */
  public float getAssets() {
    return this.assets;
  }

  /**
   * Returns the analyst recommendation 1 (sell) - 5 (buy).
   *
   * @return the analyst recommendation 1  (sell) - 5 (buy)
   */
  public float getRecommendation() {
    return this.recommendation;
  }

}
