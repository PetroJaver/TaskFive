public class TaskFive {
    private int dayOfYear;
    private DayOfWeek[] sequenceDays;

    private int startYear;
    private  int month;

    private DayOfWeek dayOfWeek;
    public TaskFive(int startYear,int dayOfMonth,int month){
        this.startYear = startYear;
        this.dayOfYear = initDayOfYear(month,dayOfMonth);
        this.month=month;
        this.dayOfWeek = initDayOfWeek();
    }


    @Override
    public String toString() {
        return dayOfWeek.toString();
    }

    private int initDayOfYear(int month,int dayOfMonth){
        int dayOfYear = 0;
        for(int i=0; i<month-1&&i!=7;i++){
            if(i!=1){
                switch (i%2){
                    case 1:
                        dayOfYear+=30;
                        break;
                    case 0:
                        dayOfYear+=31;
                        break;
                }
            }else {
                dayOfYear+=28;
            }
        }
        for(int i=7; i<month-1;i++){
                switch (i%2){
                    case 1:
                        dayOfYear+=31;
                        break;
                    case 0:
                        dayOfYear+=30;
                        break;
                }
        }
        dayOfYear +=dayOfMonth;
        return dayOfYear;
    }

    private DayOfWeek initDayOfWeek(){
        int index = dayOfYear%7;
        index+=startYear-1;
        index%=7;
        return DayOfWeek.values()[index];
    }

    public static void main(String[] args) {
        TaskFive five = new TaskFive(5,16,12);
        System.out.println(five);
    }
}

enum DayOfWeek{
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
}