import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> listOfLots;
    // The number that will be given to the next lot entered into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        listOfLots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        listOfLots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot aLot : listOfLots) {
            System.out.println(aLot.toString());
        }
    }
    public Lot removeLot(int lotNumber){ //52
        int counter = 0;
        for(Lot lot : listOfLots){
            if(lot.getNumber()==lotNumber){
                Lot removedLot = lot;
                listOfLots.remove(counter);
                return removedLot;
            }
            counter ++;
        }
        return null;
    }
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value)); //47
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null if a lot with this 
     * number does not exist.
     * @param lotNumber The number of the lot to return.
     * @return The lot with the given number, or null.
     */
    public Lot getLot(int lotNumber) //51
    {
        for(Lot lot : listOfLots){
            if(lot.getNumber() == lotNumber){
                return lot;
            }
        }
        System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
        return null;
    }
    public void close(){
        for(Lot lot : listOfLots){
            if(lot.getHighestBid() != null){
                System.out.println(lot.toString()); //48
            }
        }
    }
    public ArrayList<Lot> getUnsold(){ //49
        ArrayList<Lot> unsold =  new ArrayList<>();
        for(Lot lot : listOfLots){
            if(lot.getHighestBid() == null){
                unsold.add(lot);
            }
        }
        return unsold;
    }
}

