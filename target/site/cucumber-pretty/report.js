$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotels.feature");
formatter.feature({
  "line": 2,
  "name": "Hotels.com search feature",
  "description": "",
  "id": "hotels.com-search-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@hotels"
    },
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.before({
  "duration": 4433389464,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Hotels.com homepage is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsSD.navigateToHotelsHomePage()"
});
formatter.result({
  "duration": 872459287,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "List of all of hotel within 10 miles radius of airport or downtown",
  "description": "",
  "id": "hotels.com-search-feature;list-of-all-of-hotel-within-10-miles-radius-of-airport-or-downtown",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@hotels_2"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I select Landmark and set the max radius",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I verify system displays all hotels within 2 miles radius of Landmark",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I verify Hilton Hotel is within radius",
  "keyword": "And "
});
formatter.match({
  "location": "HotelsSD.IamOnSearchResultScreen()"
});
formatter.result({
  "duration": 7882172580,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.setDistanceForHotel()"
});
formatter.result({
  "duration": 8756545800,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.verifyHotelsWithingOneMileRadiusOfDowntown()"
});
formatter.result({
  "duration": 20327977124,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.verifyHiltonHotelInListOfSearchResults()"
});
formatter.result({
  "duration": 242764618,
  "status": "passed"
});
formatter.after({
  "duration": 200773800,
  "status": "passed"
});
});