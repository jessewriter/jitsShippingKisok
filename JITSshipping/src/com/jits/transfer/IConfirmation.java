package com.jits.transfer;

import jesseboyd.jitsShipping.address.Address;

public interface IConfirmation
{
  public String getStatus();  // starts as pending
  public Address getOrigin();
  public Address getDest();
  public String getPackageType();
  public String getDeliveryType();
  public double getWeight();
  public boolean isInsured();
  public double getDeliveryTime();
  public double getCost();
  
  /**
   * Returns a string comprising all the data.
   * NOTE: will look nicer in UI if individual items are separated with newlines, e.g.:
   * Status: Pending
   * Origin: Joe Smith
   *   215 State St.
   *   ...
   * Destination: Jane Doe
   *   211 Main St.
   *   ...
   * Package type: Box
   * Cost: 5.78
   * ...
   */
  public String toString();
}