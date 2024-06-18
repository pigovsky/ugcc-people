# Ukrainian Greek Catholic Church People (Social Network)

The "UGCC People" network facilitates people asking other people questions related to the life of their local parishes.

The questions include but not limited to Holy Mass schedule and how people take care of their children.

The UGCC People does not aim at replacing any other content-reach and feature-full social network like Facebook or messenger like WhatsApp. These monstrous social networks contain all kinds of info about everything. 

Current network, on the other hand, helps to find proper people and info in that "everything about everything" world of the existing general-purpose social networks and messengers.

## API

### API1. Login

User asks a chat-bot in some third-party messenger app like WhatsApp or Telegram for a one-time password (OTP). That OTP should be used in the following API:

`POST /api/v1/login`

Request body:
```json
{"otp": "1234"}
```

where 1234 is a OTP from the chat-bot.

Response body example:
```json
{
  "sessionKey":"07ea607a-be00-44ea-aa93-6870e7c57e24",
  "user":{
    "id":"telegram122462923",
    "firstName":"Jurgen",
    "lastName":"Pigowski",
    "telegramChatId":122462923,
    "language":"ukr"
  }
}
```

where "07ea607a-be00-44ea-aa93-6870e7c57e24" is a secret session key code.


### API2. Get Countries

Get the countries, where UGCC people live and take part in Holy Masses.

`GET /api/v1/countries`

The request should be executed with session key header like

`session-key: 07ea607a-be00-44ea-aa93-6870e7c57e24'`

where session-key value is taken from API1.

Response body example:
```json
[
  {
    "id":"Belgium",
    "name":{"ukr":"Бельгія","eng":"Belgium"}
  },
  {
    "id":"Ukraine",
    "name":{"ukr":"Україна","eng":"Ukraine"}
  }
]
```


### API3. Get Cities

Get the cities, where UGCC people live and take part in Holy Masses.

`GET /api/v1/countries/Ukraine/cities`

where Ukraine is id of one of the countries returned by API2.

The request should be executed with session key header like

`session-key: 07ea607a-be00-44ea-aa93-6870e7c57e24'`

where session-key value is taken from API1.

Response body example:
```json
[
  {
    "id":"Ukraine-Ternopil",
    "countryId":"Ukraine",
    "name":{"ukr":"Тернопіль","eng":"Ternopil"}
  },
  {
    "id":"Ukraine-Kyiv",
    "countryId":"Ukraine",
    "name":{"ukr":"Київ","eng":"Kyiv"}
  }
]
```


### API4. Get Churches

Get the churches where UGCC people take part in Holy Masses.

`GET /api/v1/countries/Ukraine/cities/Ukraine-Kyiv/churches`

where Ukraine is id of one of the countries returned by API2, 
Kyiv is id of one of the cities returned by API3.

The request should be executed with session key header like

`session-key: 07ea607a-be00-44ea-aa93-6870e7c57e24'`

where session-key value is taken from API1.

Response body example:
```json
[
  {
    "id":"Ukraine-Kyiv-Yosafata",
    "cityId":"Ukraine-Kyiv",
    "name":{
      "ukr":"Святого Йосафата поблизу станції метро Святошин",
      "eng":"Saint Josaphat near the Svyatoshyn metro station"
    }
  }, ...
]
```
