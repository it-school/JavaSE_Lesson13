package com.itschool.Task1;

import com.itschool.Task1.Exceptions.IDException;

import java.time.Duration;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

abstract public class Employee implements IEmployee {
   public static Comparator<Employee> ByNameDescending = (employee1, employee2) -> (employee2.getName().compareTo(employee1.getName()));
   public static Comparator<Employee> BySalary = new Comparator<>() {
      @Override
      public int compare(Employee employee1, Employee employee2) {
         return (int) (employee1.CalculateSalary() - employee2.CalculateSalary());
      }
   };
   public static Comparator<Employee> ByNameAscending = new Comparator<>() {
      @Override
      public int compare(Employee employee1, Employee employee2) {
         return (employee1.getName().compareTo(employee2.getName()));
      }
   };

   private static int counter = 0;
   private long ID;
   private String name;
   private Calendar birthday;

   public Employee() {
      this.name = "NoName_" + counter++;
   }

   public Employee(String name) {
      this.name = name;
   }

   public Employee(long ID) throws IDException {
      this.setID(ID);
   }

   public Employee(long ID, String name) throws IDException {
      this.setID(ID);
      this.name = name;
   }

   public Employee(long ID, String name, Calendar birthday) throws IDException {
      this.setBirthday(birthday);
      this.setID(ID);
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public long getID() {
      return ID;
   }

   public void setID(long ID) throws IDException {
/*
        ИНН (индивидуальный налоговый номер) в Украине состоит из 10 цифр. В нём зашифрованы:
        - дата рождения (первые пять цифр образуют число, равное количеству дней от 01.01.1900 до даты рождения владельца ИНН);
        - пол (чётность девятой цифры: четная цифра – женский, нечетная – мужской);
        - checksum, т.е. контрольное число (последняя цифра)
*/
      if (ID < 1000000000L || ID > 9999999999L) {
         throw new IDException();
      } else {
         if (this.birthday != null) {
/*
				ZonedDateTime date1 = ZonedDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
				ZonedDateTime date2 = ZonedDateTime.of(1981, 7, 25, 0, 0, 0, 0, ZoneId.systemDefault());
				long daysBeetween = ChronoUnit.DAYS.between(date1, date2);
				System.out.println(daysBeetween);
*/
            int digits5 = (int) (ID / 100000);
            Calendar start = new GregorianCalendar(1900, 0, 0);
            Calendar birth = new GregorianCalendar(birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH) - 1,
                    birthday.get(Calendar.DAY_OF_MONTH) - 1);
            int diff = (int) Duration.between(start.toInstant(), birth.toInstant()).toDays();
            if (diff != digits5) {
               throw new IDException();
            } else {
               this.ID = ID;
            }
         } else {
            throw new IDException();
         }
      }
   }

   public Calendar getBirthday() {
      return birthday;
   }

   public void setBirthday(Calendar birthday) {
      this.birthday = birthday;
   }

   @Override
   public String toString() {
      return "Employee: " + this.name + (this.ID > 0 ? ", " + this.ID : "");
   }
}