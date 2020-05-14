package com.sbol.narbaev.hiring;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
  private static AtomicBoolean isStopped = new AtomicBoolean(false);
  private static AtomicLong count_mail_in_first_office = new AtomicLong(50);
  private static AtomicLong count_sent_mail_in_first_office = new AtomicLong(0);
  private static AtomicLong count_mail_in_second_office = new AtomicLong(55);
  private static AtomicLong count_sent_mail_in_second_office = new AtomicLong(0);

  public static void main(String[] args) throws InterruptedException {

    Thread firstOfficeImporter = new Thread() {
      private long currentOperationCount = 0;
      private long currentOperationSleep = TimeUnit.SECONDS.toMillis(5);

      @Override
      public void run() {
        super.run();
        while (!isStopped.get()) {
          if (count_mail_in_first_office.get() == 100) {
            System.out.println("Принимающий из первого отделения уволен за плохую работу");
          } else {
            if (currentOperationCount < 20) {
              try {
                operation();
                currentOperationCount++;
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            } else {
              currentOperationCount = 0;
              try {
                if (count_mail_in_first_office.get() > 80) {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(6);
                  System.out.println("Принимающий из первого отделения уменьшил время обеда");
                } else if (count_mail_in_first_office.get() < 20) {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(5);
                  System.out.println("Принимающий из первого отделения увеличил время обеда");
                } else {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(6);
                  System.out.println("Принимающий из первого отделения вернул стандартное время обеда");
                }
                System.out.println("Принимающий из первого отделения ушёл на обед");
                long i = ThreadLocalRandom.current().nextInt(0, 6);
                count_mail_in_second_office.set(count_mail_in_second_office.get() + i);
                System.out.println("Принимающий из первого отделения подбросил " + i + " посылок во второе отделение " +
                  "во время обеда");
                Thread.sleep(currentOperationSleep);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }

      void operation() throws InterruptedException {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        count_mail_in_first_office.getAndSet(count_mail_in_first_office.get() + i);
        System.out.println("Принимающий из первого отделения принимает " + i + " посылок.");
        Thread.sleep(400);
      }
    };

    Thread firstOfficeExporter = new Thread() {
      private long currentOperationCount = 0;
      private long currentOperationSleep = TimeUnit.SECONDS.toMillis(6);

      @Override
      public void run() {
        super.run();
        while (!isStopped.get()) {
          if (count_mail_in_first_office.get() == 100) {
            System.out.println("Отправляющий из первого отделения уволен за плохую работу");
          } else {
            if (currentOperationCount < 25) {
              try {
                operation();
                currentOperationCount++;
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            } else {
              currentOperationCount = 0;
              try {
                if (count_mail_in_first_office.get() > 75) {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(5);
                  System.out.println("Отправляющий из первого отделения уменьшил время обеда");
                } else if (count_mail_in_first_office.get() < 25) {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(7);
                  System.out.println("Отправляющий из первого отделения увеличил время обеда");
                } else {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(6);
                  System.out.println("Отправляющий из первого отделения вернул стандартное время обеда");
                }
                System.out.println("Отправляющий из первого отделения ушёл на обед");
                long i = ThreadLocalRandom.current().nextInt(0, 6);
                count_mail_in_second_office.set(count_mail_in_second_office.get() + i);
                System.out.println("Отправляющий из первого отделения подбросил " + i + " посылок во второе отделение" +
                  " во время обеда");
                Thread.sleep(currentOperationSleep);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }

      void operation() throws InterruptedException {
        long i = ThreadLocalRandom.current().nextInt(1, 6);
        if (count_mail_in_first_office.get() <= i) {
          i = count_mail_in_first_office.get();
          System.out.println("Отправляющий из первого отделения отправляет меньше посылок, т.к. их осталось " + i);
        }
        count_mail_in_first_office.set(count_mail_in_first_office.get() - i);
        count_sent_mail_in_first_office.set(count_sent_mail_in_first_office.get() + i);
        System.out.println("Отправляющий из первого отделения отправляет " + i + " посылок.");
        Thread.sleep(600);
      }
    };
    Thread secondOfficeImporter = new Thread() {
      private long currentOperationCount = 0;
      private long currentOperationSleep = TimeUnit.SECONDS.toMillis(6);

      @Override
      public void run() {
        super.run();
        while (!isStopped.get()) {
          if (count_mail_in_second_office.get() == 100) {
            System.out.println("Принимающий из второго отделения уволен за плохую работу");
          } else {
            if (currentOperationCount < 23) {
              try {
                operation();
                currentOperationCount++;
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            } else {
              currentOperationCount = 0;
              try {
                if (count_mail_in_second_office.get() > 79) {
                  currentOperationSleep = 6500;
                  System.out.println("Принимающий из второго отделения уменьшил время обеда");
                } else if (count_mail_in_second_office.get() < 19) {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(4);
                  System.out.println("Принимающий из второго отделения увеличил время обеда");
                } else {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(6);
                  System.out.println("Принимающий из второго отделения вернул стандартное время обеда");
                }
                System.out.println("Принимающий из второго отделения ушёл на обед");
                long i = ThreadLocalRandom.current().nextInt(0, 8);
                count_mail_in_first_office.set(count_mail_in_first_office.get() + i);
                System.out.println("Принимающий из второго отделения подбросил " + i + " посылок в первое отделение " +
                  "во время обеда");
                Thread.sleep(currentOperationSleep);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }

      void operation() throws InterruptedException {
        int i = ThreadLocalRandom.current().nextInt(1, 3);
        count_mail_in_second_office.getAndSet(count_mail_in_second_office.get() + i);
        System.out.println("Принимающий из второго отделения принимает " + i + " посылок.");
        Thread.sleep(450);
      }
    };

    Thread secondOfficeExporter = new Thread() {
      private long currentOperationCount = 0;
      private long currentOperationSleep = TimeUnit.SECONDS.toMillis(5);

      @Override
      public void run() {
        super.run();
        while (!isStopped.get()) {
          if (count_mail_in_second_office.get() == 100) {
            System.out.println("Отправляющий из второго отделения уволен за плохую работу");
          } else {
            if (currentOperationCount < 27) {
              try {
                operation();
                currentOperationCount++;
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            } else {
              currentOperationCount = 0;
              try {
                if (count_mail_in_second_office.get() > 72) {
                  currentOperationSleep = 45000;
                  System.out.println("Отправляющий из второго отделения уменьшил время обеда");
                } else if (count_mail_in_second_office.get() < 23) {
                  currentOperationSleep = 6500;
                  System.out.println("Отправляющий из второго отделения увеличил время обеда");
                } else {
                  currentOperationSleep = TimeUnit.SECONDS.toMillis(5);
                  System.out.println("Отправляющий из второго отделения вернул стандартное время обеда");
                }
                System.out.println("Отправляющий из второго отделения ушёл на обед");
                long i = ThreadLocalRandom.current().nextInt(0, 8);
                count_mail_in_first_office.set(count_mail_in_first_office.get() + i);
                System.out.println("Отправляющий из второго отделения подбросил " + i + " посылок в первое отделение" +
                  " во время обеда");
                Thread.sleep(currentOperationSleep);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }

      void operation() throws InterruptedException {
        long i = ThreadLocalRandom.current().nextInt(1, 5);
        if (count_mail_in_second_office.get() <= i) {
          i = count_mail_in_second_office.get();
          System.out.println("Отправляющий из второго отделения отправляет меньше посылок, т.к. их осталось " + i);
        }
        count_mail_in_second_office.set(count_mail_in_second_office.get() - i);
        count_sent_mail_in_second_office.set(count_sent_mail_in_second_office.get() + i);
        System.out.println("Отправляющий из второго отделения отправляет " + i + " посылок.");
        Thread.sleep(550);
      }
    };

    firstOfficeImporter.start();
    firstOfficeExporter.start();
    secondOfficeImporter.start();
    secondOfficeExporter.start();

    Thread.sleep(TimeUnit.MINUTES.toMillis(2));
    isStopped.set(true);
    System.out.println("-----ИТОГИ-----");
    System.out.println("Всего отправлено первым отделением: " + count_sent_mail_in_first_office.get());
    System.out.println("Всего есть посылок в первом отделении: " + count_mail_in_first_office.get());
    System.out.println("Всего отправлено вторым отделением: " + count_sent_mail_in_second_office.get());
    System.out.println("Всего есть посылок во втором отделении: " + count_mail_in_second_office.get());
    System.out.println("-----ИТОГИ-----");
    System.out.println("По итогам дня премируется: " + (count_sent_mail_in_first_office.get() > count_sent_mail_in_second_office.get() ?
      "Первое отделение" :
      "Второе" +
        " отделение"));
  }
}
