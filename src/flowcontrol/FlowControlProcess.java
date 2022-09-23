/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowcontrol;

import Serial.Serial;
import Arduino.ArduinoState;
import java.io.IOException;

/**
 *
 * @author cabrittin
 */
public class FlowControlProcess {
    //Mode: ON(1) or OFF (0,default)
    //pins: Array [inject, flush, stimulus] Default of false for each
    //Stimulus mode:  Continuous (1) or Pulse (0, default)
    //Arduino pins byte value (Pin : byte val):
    //8 : 0
    //9 : 2
    //10: 4
    
    private FlowControlParams fcp_;
    private Serial ser_;
    private ArduinoState ars_ = new ArduinoState();
    
    private int OFF = 0;
    private int[] pin_states = {1,2,4}; //[inject flush stimulus] state values
    private double MAX_TIME = Math.pow(2,17)-1; //max number of ms because times transitted as 2 bytes (16 bits) int
    
    public void trigger(Serial ser, FlowControlParams fcp) throws IOException{
        fcp_ = fcp;
        ser_ = ser;
        int state = ars_.computeState(fcp_.getPinState());
        ars_.setState(ser_,state);
    }
    
    public void triggerPulse(Serial ser, FlowControlParams fcp) throws IOException{
        fcp_ = fcp;
        ser_ = ser;
        ars_.setNumberOfPaterns(ser_, 2);
        ars_.loadSequence(ser_,new int[] {pin_states[2],0});
        ars_.loadIntervals(ser_,fcp_.getIntervals());
        ars_.loadRepeats(ser_,fcp_.getPulseNum());
        ars_.triggerSequence(ser_);
    }
    
    public void triggerInject(Serial ser) throws IOException{
        ser_ = ser;
        ars_.setState(ser_,pin_states[0]);
    }
    
    public void triggerFlush(Serial ser) throws IOException{
        ser_ = ser;
        ars_.setState(ser_,pin_states[1]);
    }
    
    public void triggerStimulus(Serial ser) throws IOException{
        ser_ = ser;
        ars_.setState(ser_,pin_states[2]);
    }    
    
    public void turnOff(Serial ser) throws IOException{
        ser_ = ser;
        ars_.turnOff(ser_);
    }
    
   
    
}
