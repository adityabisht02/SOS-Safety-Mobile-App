# Insta-SOS

This app will send an SOS message to 6 of your contacts along with your live location.

## How it works
This app uses native android with java. I used the Location feature to grab the user's location, 
the Geocoder feature to reverse geocode the lat and longitude to an address, and the SMS feature to send a quick SMS to all saved contacts. 
To save phone numbers who can receive this message, I have used ROOM database (this is a local database built on top of SQLite).
Hence contacts are stored inside room database.

![image](https://user-images.githubusercontent.com/89146189/232293601-ed6f0cb1-cf87-4a89-8046-b307d8183a27.png)

