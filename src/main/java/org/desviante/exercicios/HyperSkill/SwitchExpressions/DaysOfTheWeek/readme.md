# Days of the week

Rewrite the following switch statement as a switch expression using the code template below. Feel free to assign numLetters to whatever you wish, but do not alter the other code.

Please ignore the MagicNumberCheck code style issue here.

```java
private enum DaysOfTheWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

switch (day) {
        case MONDAY:
        case FRIDAY:
        case SUNDAY:
            numLetters = 6;
            break;
        case TUESDAY:
            numLetters = 7;
            break;
        case THURSDAY:
        case SATURDAY:
            numLetters = 8;
            break;
        case WEDNESDAY:
            numLetters = 9;
            break;
        default:
            throw new IllegalStateException("Invalid day: " + day);
    }
```

## Sample Input 1:

MONDAY

## Sample Output 1:

6