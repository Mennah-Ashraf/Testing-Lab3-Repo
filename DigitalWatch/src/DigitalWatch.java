public class DigitalWatch {
    public String DigitalWatch ( String input ){
        int len = input.length();
        int m=0 ,h = 0;
        int D = 1,M = 1;
        int Y = 2000;
        String s;
        String state = "Normal_Display";
        String i1 = "Time";
        String i2 = "Alarm";
        String i3 = "min";

        for(int i=0; i< len; i++){
            switch (state){

                case "Normal_Display" : {
                    if ( input.charAt(i) == 'c' )
                        state = "Update";
                    if ( input.charAt(i) == 'b' )
                        state = "Alarm_Set";
                    if ( input.charAt(i) == 'a' ){
                        if( i1 == "Time")
                            i1 = "Date";
                        else
                            i1 = "Time";
                    }
                    break;
                }

                case "Alarm_Set" : {
                    if ( input.charAt(i) == 'a' ) {
                        if (i2 == "Alarm")
                            i2 = "Alarm_Set";
                    }
                    if ( input.charAt(i) == 'd' )
                        state = "Normal_Display";
                    break;
                }

                case "Update" : {
                    if (input.charAt(i) == 'a') {
                        if (i3 == "min")
                            i3 = "hour";
                        else if (i3 == "hour")
                            i3 = "day";
                        else if (i3 == "day")
                            i3 = "month";
                        else if (i3 == "month")
                            i3 = "year";
                        else if (i3 == "year")
                            state = "Normal_Display";
                    }

                    if (input.charAt(i) == 'b'){
                        if (i3 == "min") {
                            if (m < 60)
                                m++;
                            else
                                m=0;
                        }
                        else if (i3 == "hour")
                            if ( h < 24)
                                h++;
                            else
                                h=0;
                        else if (i3 == "day")
                            if ( D < 31)
                                D++;
                            else
                                D=1;
                        else if (i3 == "month")
                            if ( M < 12)
                                M++;
                            else
                                M=1;
                        else if (i3 == "year")
                            if ( Y < 2100)
                                Y++;
                    }

                    if (input.charAt(i) == 'd')
                        state = "Normal_Display";
                    break;
                }
            }
        }

        if (state == "Normal_Display") {
            s = i1;
        }
        else if (state == "Alarm_Set"){
            s = i1;
        }
        else {
            s = i1;
        }

        return "Current state: " + state + ", the inner state: " + s + "  Date: " +
                String.valueOf(D) + " - " + String.valueOf(M) + " - " +String.valueOf(Y) +
                "  Time: " + String.format("%02d", h) + ":" + String.format("%02d", m);
    }
}

