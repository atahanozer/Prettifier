Write a number prettifier: Write tested code that accepts a numeric type and returns a truncated, "prettified" string version. The prettified version should include one number after the decimal when the truncated number is not an integer. It should prettify numbers greater than 6 digits and support millions, billions and trillions.

Assumptions:
- User input is scanned through console.
- Negative numbers can be prettified.
- Numbers with absolute value less than 1000000, are returned unchanged. 

Design: 

There are three classes:
- Prettify class, which includes the main method and provides a scanner to user to enter a number to format.
- PrettifyFormatter class, which does the work of formatting the number.
- TestPrettifier class, a JUnit test to validate the results of the PrettifyFormatter class.
- Maven is used for build management.

The code surely needs some improvements. Such as:

- Provide i18n localized output strings.
- Examine input better and deal with edge cases rather than rely on exception handling.
- Accept other Locales, instead of treating the local environment as the only one.

Build Notes: 
- You can import the code as an existing Maven project into Eclipse and run project as "Maven Build".
- Run project (or Prettify.java) as 'Java Application' to start program.
- Run project as 'JUnit Test' to test project.