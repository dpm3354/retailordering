# retailordering
A project to demonstrate how to work with Mock Objects. 
D Paul Merrill of Beaufort Fairmont

Catch the webinar "What's a Mock Object and How Do I Use It?" on 9/21/17 or find the recording at 
http://BeaufortFairmont.com/webinars.

My starting todo list was this:
* give sku
* get price
* give payment type
* give payment info
* manage inventory
* set up delivery

Each of these features are done using mocks. In other words, there is no working "retail ordering" system in this code. It
is the code we'd write using TDD and Mocks. 

Watch the logs and the commits from the beginning until 9/12 to see how I went about adding features to this and testing 
the code before any functionality existed.



** Hand-crafted Mocks **

The first iteration of this code (~ Sept 12, 2017) I wrote my own mocks. This was a practice I enjoyed many years ago
before some of the great mocking frameworks (and dependency injection) were widespread.

The mocks in src/test/java/handcrafted directory show a few techniques for interacting with mock objects. Notice they
break some rules of good design that we'd keep in product code. For instance, these mocks are a bit more intimate than
we'd typically like in production code. They share members publicly and they purposefully use side effects to achieve 
testability. 

See Michael Feather's great book "Working Effectively with Legacy Code" for where much of this thinking on design and 
testing came from.



** Mockito **

The second iteration of this code (~ Sept 13, 2017) I implemented the same test cases using Mockito mocking framework. 
Find more info on Mockito at http://site.mockito.org/

Once again, watch the commits to see the progress. Also, diff or compare the two OrderTests.java files to see how to use
the handcrafted mocks versus the Mockito mocks.




** Other Mock Frameworks **

I may add other mock frameworks in here at some point.

