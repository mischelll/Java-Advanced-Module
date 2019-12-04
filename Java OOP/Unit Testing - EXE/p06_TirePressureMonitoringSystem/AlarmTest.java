package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    private Alarm alarm;
    private Sensor sensor;


    @Before
    public void setup(){
        this.sensor = mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void alarmShouldSetOffWhenNotInRange(){
        when(this.sensor.popNextPressurePsiValue()).thenReturn(5.5);
        this.alarm.check();
        boolean alarmOn = this.alarm.getAlarmOn();


        assertTrue(alarmOn);
    }

    @Test
    public void alarmShouldBeOffWhenInRange(){
        when(this.sensor.popNextPressurePsiValue()).thenReturn(18.9);
        this.alarm.check();
        boolean alarmOn = this.alarm.getAlarmOn();

        assertFalse(alarmOn);
    }
}
