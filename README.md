# Unofficial Robinhood Api - Java Wrapper (AMPro Fork)
### A Java wrapper providing easy access to the [Unofficial Robinhood Api](https://github.com/sanko/Robinhood).

Thanks to [Conrad Weiser](https://github.com/ConradWeiser) for making
[the orginal wrapper project](https://github.com/ConradWeiser/Unofficial-Robinhood-Api)
. Without them, this fork would literally be impossible!

## Contents
- [Installation](#INSTALL)
    - [Dependencies](#DEPEN)
- [Usage](#USAGE)
- [RoadMap](#RDMP)
- [Contributing](#CONTR)
- [Log](#LOG)

<a name='INSTALL'></a>
## Installation
To install & use the Robinhood API, you can either install the latest
[release](https://github.com/AquaticMasteryProductions/Robinhood-Api-Java/releases)
, download the latest source code & build the project yourself,
or use [JitPack](https://jitpack.io/) to add the repository to your 
gradle, maven, sbt, or leiningen.
You can download the latest stable build here:

<a name='DEPEN'></a>
#### The Robinhood API Depends on these projects & packages
- [Mashape's Unirest](http://unirest.io/java.html)
- [Google's Gson](https://github.com/google/gson)

<a name='RDMP'></a>
## Roadmap
#### TOP: The structure of the ConfigManager needs to be restructured
from static/global management to instance-based authorization. The top
option right now is to change ConfigManager to just a "local" config
for each API instance (this is to allow for multiple APIs logged in to
different accounts)

-  ~~Logging users in and out~~
- ~~Get account information~~
[(JSON Response contents)](https://github.com/sanko/Robinhood/blob/master/Account.md#gather-list-of-accounts)
- ~~Getting information about tickers~~
- Imporve & clarify many, many vague exceptions
- Orders
    - Get
        - Get full history (live and closed orders)
    - Post
        - ~~Make &~~ cancel orders (limit, stop, etc)
- ...
- Include a more comprehensive guide on what data you are getting from
each method.

### Things that will likely *never* happen here
- Transfering funds from bank accounts to Robinhood & visa versa.
    - That's a *lot* of security
    [we can't provide](https://www.youtube.com/watch?v=2bVhjOcz0s0)
    (at least not now) and will leave it to Robinhood & their applications.

<a name='CONTR'></a>
## Contributing
I am *very* new to web and REST implentations, so really...*help*.
Any pull requests will be looked over and (likely) accepted given they follow
a few guidlines:

- Documentation
    - Classes & methods must have docs, unless they are increadibly
    intuituve (e.g. ``getAccountId()``).
    - We cant accept your code if we don't know what's going on, and we don't
    have time to decrypt your methods, as good as they might be.
- Adding new Dependencies
    - If you use an external library, it should be available from the
    maven/gradle repositories or a reputable library wtih gradle compatablity,
    since this library is built from gradle.
    - Try to keep any new external dependencies to a minimum. We will accept
    most things from reputable sources (Apache, Google, etc), but we
    still reserve the right to deny any pull requests that add too many and/or
     unreliable dependencies.
- Prettyness
    - We're pretty open to coding styles here, everyone has their prefered way
    to code, but at some point...*ya gotta look consistant*.
    1. ``for``, ``if``, ``while``, etc should have curly braces. We know it
    looks so *minimalistic* without them, but it helps code reading a ton!
    2. Try your best to keep lines under ``80`` characters and *must* be under
    ``90``.
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
`` ``
    - If you find anything in the existing code, feel free to correct or point
    it out, nobody's perfect...

<a name='USAGE'></a>
## Usage (From Conrad)

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
System.out.println(accountNumber + " : " + buyingPower);
```

### For more detailed instructions on usage, [Click me!](https://github.com/AquaticMasteryProductions/Robinhood-Api-Java/wiki/Usage)

## Disclaimer
(This is from org. author but it applies to me too)<br><br>
I have never taken up a project working with APIs like this.
I intend to write this wrapper to the best of my ability, and continue to
give support/make changes as time passes.

However, that being said, I aim to make the finished project both efficient in
terms of how much computing power it requires, and easy for other developers to
build functionality on top of.

If you have any questions feel free to email AMPro at
aquaticmasteryproductions@gmail.com

-- Jono

<a name='LOG'><a/>
## Log
- 6/19/18
    - Geting multiple quotes by their tickers.
    - 1st Reddit post
- 6/15/18
    - Work on understanding the API basis from
    [conrad's repo](https://github.com/ConradWeiser/Unofficial-Robinhood-Api)
    - Get live & closed orders from API & SecurityOrderListElement cerated to
    hold the paginated return.
- 6/14/18 ***The Journey Begins***



