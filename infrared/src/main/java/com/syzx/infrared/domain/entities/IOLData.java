/**
  * Copyright 2017 bejson.com 
  */
package com.syzx.infrared.domain.entities;
import java.util.List;

/**
 * Auto-generated: 2017-12-08 13:4:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class IOLData {

    private boolean in_valid;
    private List<Integer> input;
    private List<Integer> output;
    public void setIn_valid(boolean in_valid) {
         this.in_valid = in_valid;
     }
     public boolean getIn_valid() {
         return in_valid;
     }

    public void setInput(List<Integer> input) {
         this.input = input;
     }
     public List<Integer> getInput() {
         return input;
     }

    public void setOutput(List<Integer> output) {
         this.output = output;
     }
     public List<Integer> getOutput() {
         return output;
     }

}