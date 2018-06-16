# Unofficial Robinhood Api - Java Wrapper (AMPro Fork)
### A Java wrapper providing easy access to the [Unofficial Robinhood Api](https://github.com/sanko/Robinhood).

Thanks to [Conrad Weiser](https://github.com/ConradWeiser) for making
[the orginal wrapper project](https://github.com/ConradWeiser/Unofficial-Robinhood-Api)
. Without them, this fork would literally be impossible!

## Contents
- [Installation](#INSTALL)
- [RoadMap](#RDMP)
- [Contributing](#CONTR)
- [Log](#LOG)

<a name='INSTALL'></a>
## Installation
(*Sorry, still working on this part*.)
You can download the repo or a jar from the
[releases](https://github.com/AquaticMasteryProductions/Robinhood-Api-Java/releases)
if you want to use this library. Gradle/Maven incoming...*hopefully*

<a name='RDMP'></a>
## Roadmap
-  ~~Logging users in and out~~
- ~~Get account information~~
[(JSON Response contents)](https://github.com/sanko/Robinhood/blob/master/Account.md#gather-list-of-accounts)
- ~~Getting information about tickers~~
- Get Portfolio & watchlist
- Orders
    - Get
        - Get full history (live and closed orders)
    - Post
        - Make & cancel orders (limit, stop, etc)
        - Set Complex orders with take-profit & (trailing)stoploss
- ...

- Include a more comprehensive guide on what data you are getting from each method (Probably within the javadocs)
- Continue implementing more of the working methods we have available
- Streamline the library framework in general. Currently things work very well, but it's not perfect

<a name='CONTR'></a>
## Contributing
I am *very* new to web and REST implentations, so really...*help*.
Any pull requests will be looked over and (likely) accepted given they follow
a few guidlines:

- Documentation
    - ALL CLASSES & METHODS MUST BE DOCUMENTED!
    - We cant accept your code if we don't know what's going on, and we don't
    have time to decrypt your method calls and intentions, as good as they might be.
- Adding new Dependencies
    - If you use an external library, it MUST be available from the maven
    repositories, since this library is built from gradle.
    - Try to keep any new external dependencies to a minimum. We will accept
    most things from tried & reputable sources (Apache, Google, etc), but we
    still reserve the right to deny any pull requests that add too many and/or
     unreliable dependencies.
- Prettyness
    - We're pretty open to coding styles here, everyone has their prefered way
    to code, but at some point...*ya gotta look consistant*. So in no particular order:
    1. ``for``, ``if``, ``while``, etc ***MUST*** have curly braces. We know it looks so
    *minimalistic* without them, but it helps code reading a ton!
    2. Try your best to keep lines under ``80`` characters and *must* be under 90.
    If a method or constructor is called and it ends up being too long, let it
    span across multiple lines, like so (no need to be perfect, just...similar)...
```java
Thing thisThing = new Thing(param, other param,
                            more param, so much param);
//or
thisThing.superCoolMethod(
            "Wow this param is such a stupid long string wow...maybe too long?"
);
```


<a name='LOG'><a/>
## Log
- 6/15/18
    - Work on understanding the API basis from
    [conrad's repo](https://github.com/ConradWeiser/Unofficial-Robinhood-Api)
    - Get live & closed orders from API & SecurityOrderListElement cerated to
    hold the paginated return.
- 6/14/18 ***The Journey Begins***

## Usage

[Javadocs available - Click me!](https://conradweiser.github.io/Unofficial-Robinhood-Api/)
This library is built with the intention of making extracting information from the Robinhood API as easy as possible.

Say for the following example, we want to get our account number, and how much buying power we have available

```java
//Providing a username and password automatically logs the instance into our account!
RobinhoodApi api = new RobinhoodApi("username", "password");

//Make the request for all of the account information
AccountElement accountData = api.getAccountData();

//Extract the data we want
String accountNumber = accountData.getAccountNumber();
Float buyingPower = accountData.getBuyingPower();

//Print to console!
System.out.println(accountNumber + " : " + String.valueOf(buyingPower));
```

### For more detailed instructions on usage, [Click me!](https://github.com/ConradWeiser/Unofficial-Robinhood-Api/blob/master/Usage.md)


## Disclaimer
I have never taken up a project working with APIs like this. I intend to write this wrapper to the best of my ability, and continue to give support/make changes as time passes.

I however am a student, and have never programmed in a professional enviroment. Things might seem a little messy until the library gets a little closer to completion.

However, that being said, I aim to make the finished project both efficient in terms of how much computing power it requires, and easy for other developers to build functionality on top of. Stay tuned for future updates!
____

If you have any questions, comments or suggestions, please do throw me an Email!


