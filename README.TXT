Project: auction
Authors: David J. Barnes and Michael Kölling

This project is part of the supplementary material for
chapter 4 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

Purpose of project: To demonstrate collections of objects
How to start this project:
    + Create an Auction object.

    + Enter a few lots via its enterLot method. Only String
    descriptions of the lots are required.

    + Create one or more Person objects to represent bidders.

    + Show the lots and decide on one to bid for. Make a note
      of the lot number.

    + Enter a bid for the lot by calling the makeABid method on
      the Auction object. Pass the number of the lot, the Person
      who is bidding, and the amount of the bid.

50. This would mess up the getLot method, as it relies on the lot number being one more
than its index in the list. Calling anything after the removed lot would result in getting the
index after it.
51.