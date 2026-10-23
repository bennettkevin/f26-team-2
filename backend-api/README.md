# LocalGuide Backend API

# UML Class Diagram

[Class Diagram](../docs/LocalGuides%20UML.png)

# API Overview

**Version:** 1.0
**Last Updated** 10/23/2026

**Base URL:**

- Local: http://localhost:8080/api
- Production: 

# Provider Endpoints

| Method | Path                               | Purpose                | Response    | Implementing Developer | User Story |
|--------|------------------------------------|------------------------|-------------|------------------------|------------|
| 'POST' | '/api/guides'                      | Register Guide Account | 201 Created | Kevin                  | [US-5](../docs/LocalGuideSRS.md) |
| 'PUT'  | '/api/guides'                      | Update Guide Account   | 200 OK      | Kevin                  | [US-5](../docs/LocalGuideSRS.md) |
| 'POST' | '/api/guideTours'                  | Create a Guide service | 201 Created | Kevin                  | [US-6](../docs/LocalGuideSRS.md) |
| 'GET'  | '/api/guides/{guideId}/statistics' | View guide statistics  | 200 OK      | Kevin                  | [US-7](../docs/LocalGuideSRS.md) |
| 'GET'  | '/api/guideTours/{tourId}/reviews' | View tour reviews      | 200 OK      | Kevin                  | [US-8](../docs/LocalGuideSRS.md) |
| 'POST' | '/api/reviews/{reviewId}/replies'  | Reply to review        | 200 OK      | Kevin                  | [US-8](../docs/LocalGuideSRS.md) |

### Example Guide Request

```http
POST /api/guides
Content-Type: application/json

{
	"FName": "test",
	"LName": "guide",
	"bio": "Test Bio",
	"city": "TestCity",
	"email": "test@test.com",
	"password": "somepass123",
	"profilePicture": null,
	"state": "Postteststate"
}
```

### Example Guide Tour Request

```http
POST /api/guideTours
Content-Type: application/json

{
		"guide": {
			"FName": "test",
			"LName": "guide",
			"bio": "Test Bio\t",
			"city": "TestCity\t\t",
			"email": "test@test.com",
			"hibernateLazyInitializer": {},
			"id": 2,
			"password": "somepass123",
			"profilePicture": null,
			"state": "teststate"
		},
		"tourCity": "testCity",
		"tourDescription": "test tour",
		"tourImage": null,
		"tourName": "testTour",
		"tourPrice": 11,
		"tourState": "teststate"
	}
```
### Example Review Reply Request

```http
POST /api/reviews/{reviewId}/replies
Content-Type: application/json

{
	"booking": {
		"bookingTime": "2026-10-21T04:00:03",
		"city": "High point",
		"customer": {
			"FName": "Jeremy",
			"LName": "Piven",
			"bio": "Cyclist looking for new trails to bike on.",
			"city": "High Point",
			"email": "twowheels@gmail.com",
			"hibernateLazyInitializer": {},
			"id": 1,
			"profilePicture": null,
			"state": "North Carolina"
		},
		"description": "Swimming",
		"guide": {
			"FName": "test",
			"LName": "guide",
			"bio": "Test Bio\t",
			"city": "TestCity\t\t",
			"email": "test@test.com",
			"hibernateLazyInitializer": {},
			"id": 2,
			"password": "somepass123",
			"profilePicture": null,
			"state": "teststate"
		},
		"hibernateLazyInitializer": {},
		"id": 4,
		"location": "Pool",
		"state": "North Carolina",
		"timeslot": {
			"endTime": "2026-11-12T17:00:00",
			"guideTour": {
				"guide": {
					"FName": "test",
					"LName": "guide",
					"bio": "Test Bio\t",
					"city": "TestCity\t\t",
					"email": "test@test.com",
					"hibernateLazyInitializer": {},
					"id": 2,
					"password": "somepass123",
					"profilePicture": null,
					"state": "teststate"
				},
				"hibernateLazyInitializer": {},
				"id": 2,
				"tourCity": "PuttestCity",
				"tourDescription": "Puttest tour",
				"tourImage": null,
				"tourName": "PuttestTour",
				"tourPrice": 11.5,
				"tourState": "Postteststate"
			},
			"hibernateLazyInitializer": {},
			"id": 1,
			"isAvailable": true,
			"startTime": "2026-11-12T12:00:00"
		},
		"title": "Swim guys go swim"
	},
	"comments": "Fun",
	"customer": {
		"FName": "Jeremy",
		"LName": "Piven",
		"bio": "Cyclist looking for new trails to bike on.",
		"city": "High Point",
		"email": "twowheels@gmail.com",
		"hibernateLazyInitializer": {},
		"id": 1,
		"profilePicture": null,
		"state": "North Carolina"
	},
	"guide": {
		"FName": "test",
		"LName": "guide",
		"bio": "Test Bio\t",
		"city": "TestCity\t\t",
		"email": "test@test.com",
		"hibernateLazyInitializer": {},
		"id": 2,
		"password": "somepass123",
		"profilePicture": null,
		"state": "teststate"
	},
	"replyText": "Post Test Thank you",
	"reviewDate": "2026-10-22T07:00:00"
}
```

# Deployment 

- Deployed on Render: [Link](Place deployment link here.)

Note: Render free tier servers will spin down after ~15 minutes of inactivity. Because of this it can take up to 1-1.5 minutes for the first request after spin down to get back.