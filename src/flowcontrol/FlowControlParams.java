/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowcontrol;

/**
 *
 * @author cabrittin
 */
public class FlowControlParams {
    private int mode = 0;           //Arduino ON (1) or OFF (0, defaul)
    private boolean[] pins = new boolean[3]; //Array [inject, flush, stimulus] Default of 0 for each
    private int stimulus_mode = 0;  //Stimulus mode Continuous (1) or Pulse (0, default)
    private int pulse_num = 1000;  //Number of pulses to deliver
    private int[] intervals = {1000,1000}; //{Pulse On, Pulse Off}
    
    public void setMode(int x){
        this.mode = x;
    }
    
    public void setPin(String s){
        int i = this.whichPin(s);
        if (i > -1){
            this.pins[i] = !this.pins[i];
        }
    }
    
    public void setStimulusMode(int x){
        this.stimulus_mode = x;
    }
    
    public void setPulseOn(int x){
        this.intervals[0] = x;
    }
    
    public void setPulseOff(int x){
        this.intervals[1] = x;
    }
    
    public void setPulseNum(int x){
        this.pulse_num = x;
    }
    
    public int getMode(){
        return this.mode;
    }
    
    public boolean getPin(String s){
        int i = this.whichPin(s);
        boolean val = false;
        if (i > -1){
            val = this.pins[i];
        }
        return val;
    }
    
    public boolean[] getPinState(){
        return this.pins;
    }
    
    public int getStimulusMode(){
        return this.stimulus_mode;
    }
    
    public int getPulseOn(){
        return this.intervals[0];
    }
    
    public int getPulseOff(){
        return this.intervals[1];
    }
    
    public int getPulseNum(){
        return this.pulse_num;
    }
    
    public int[] getIntervals(){
        return this.intervals;
    }
    
    private int whichPin(String s){
        int i = -1;
        if (s.equals("inject")){
            i = 0;
        } else if (s.equals("flush")){
            i = 1;
        } else if (s.equals("stimulus")){
            i = 2;
        } else {
            System.err.println("Error: Unknown string!");
        }
        return i;
    }  
}
