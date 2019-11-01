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
formatter.scenarioOutline({
  "line": 33,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 32,
      "name": "@hotels_3"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I select property \u003cstar\u003e star class",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I verify system displays only selected star hotels on search result",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;",
  "rows": [
    {
      "cells": [
        "star"
      ],
      "line": 39,
      "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;1"
    },
    {
      "cells": [
        "5-star"
      ],
      "line": 40,
      "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;2"
    },
    {
      "cells": [
        "4-star"
      ],
      "line": 41,
      "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;3"
    },
    {
      "cells": [
        "3-star"
      ],
      "line": 42,
      "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5872026967,
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
  "duration": 1196318840,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@hotels"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 32,
      "name": "@hotels_3"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I select property 5-star star class",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I verify system displays only selected star hotels on search result",
  "keyword": "Then "
});
formatter.match({
  "location": "HotelsSD.IamOnSearchResultScreen()"
});
formatter.result({
  "duration": 11858963028,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5-star",
      "offset": 18
    }
  ],
  "location": "HotelsSD.selectStars(String)"
});
formatter.result({
  "duration": 4159131534,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.filterResultsDisplayOnlyNStartsHotels()"
});
formatter.result({
  "duration": 34156634,
  "status": "passed"
});
formatter.after({
  "duration": 223078889,
  "status": "passed"
});
formatter.before({
  "duration": 7032185810,
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
  "duration": 1006068328,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@hotels"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 32,
      "name": "@hotels_3"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I select property 4-star star class",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I verify system displays only selected star hotels on search result",
  "keyword": "Then "
});
formatter.match({
  "location": "HotelsSD.IamOnSearchResultScreen()"
});
formatter.result({
  "duration": 27843489050,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4-star",
      "offset": 18
    }
  ],
  "location": "HotelsSD.selectStars(String)"
});
formatter.result({
  "duration": 4147917453,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.filterResultsDisplayOnlyNStartsHotels()"
});
formatter.result({
  "duration": 169650174,
  "status": "passed"
});
formatter.after({
  "duration": 193340939,
  "status": "passed"
});
formatter.before({
  "duration": 5527303660,
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
  "duration": 1007684954,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "hotels.com-search-feature;verify-user-can-only-view-the-result-by-selected-property-class;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@hotels"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 32,
      "name": "@hotels_3"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I select property 3-star star class",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I verify system displays only selected star hotels on search result",
  "keyword": "Then "
});
formatter.match({
  "location": "HotelsSD.IamOnSearchResultScreen()"
});
formatter.result({
  "duration": 9975766355,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3-star",
      "offset": 18
    }
  ],
  "location": "HotelsSD.selectStars(String)"
});
formatter.result({
  "duration": 4144063596,
  "status": "passed"
});
formatter.match({
  "location": "HotelsSD.filterResultsDisplayOnlyNStartsHotels()"
});
formatter.result({
  "duration": 170854102,
  "status": "passed"
});
formatter.after({
  "duration": 163858803,
  "status": "passed"
});
});