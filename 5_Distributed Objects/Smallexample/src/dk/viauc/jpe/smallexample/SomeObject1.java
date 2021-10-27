/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */

package dk.viauc.jpe.smallexample;

import java.io.Serializable;

public class SomeObject1 implements Serializable
{
  private int value;

  public void setValue(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }
}