
# Requirements

**Project Name:** LocalGuide \
**Team:** Kevin (Provider) Justice (Customer) \
**Course:** CSC 340 \
**Version:** 1.0\
**Date:** 2026-08-25

---

## 1. Overview
**Vision.** LocalGuides is for people moving to, or exploring, a new area; and providers to offer services related to their area of expertise. Customers will have the ability to search for guides in the area that they are going, and find the right match based on their specific interests. Providers will be able to offer these guide services to gain customer base and show the history and fun associated with their area.

**Glossary** Terms used in the project
- **Services:** Refers to providing customers with the ability to view locations and activities, and the ability to book appointments with guides on the application.
- **Activities:** Refers to the forms of recreation that the customer can engage in after finding a guide. Examples include touring a new location, or playing a new sport.

**Primary Users / Roles.**
- **Customer** — Customers should be able to see what activities are available in their local area, and find locals that can guide them through said activities.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — Providers should be able to provide activities and guide services for customers.

**Scope (this semester).**
- Users can register profiles.
- Customers may search for guide services that fit their needs.
- Customers can book guide services.
- Providers can offer guide services.
- Reviews for guide services.

**Out of scope (deferred).**
- <deferred 1: Give customers the ability to post requests for guides for activities that are not currently listed.>
- <deferred 2: Give customers and guides the ability to report malicious and dangerous behavior exhibited by a customer or guide.>

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑1 — <Create an accout>**  
  _Story:_ As a customer, I want to register an account so that I can utilize the services provided.
  _Acceptance:_
  ```gherkin
  Scenario: <Register with email>
    Given <I do not already have an account>
    When  <I provide a valid email>
    Then  <I should have an account and profile>
    And   <Utilize the app's services>
  ```

- **US‑2 — <Browse available services>**  
  _Story:_ As a customer, I want to view available guides and activities, so that I can see what services are actually at my disposal. 
  _Acceptance:_
  ```gherkin
  Scenario: <Navigate available listings>
    Given <I am registered as a customer>
    When  <I search the app>
    Then  <I will see what I can do in the area>
    And   <Who can guide me>
  ```

  **US‑3 — <Subscribe to guides, locations, and activities>**  
  _Story:_ As a customer, I want to subscribe to guides, activities, and locations, so that I can be consistently updated on news related to my subscriptions. 
  _Acceptance:_
  ```gherkin
  Scenario: <Subscribe to topics and guides>
    Given <There are guides, activities, and locations I want stay informed on>
    When  <I subscribe to one of these>
    Then  <I will know when there are new developments regarding my subscriptions>
  ```

  **US‑4 — <Review providers>**  
  _Story:_ As a customer, I want to be able to leave reviews on providers' profiles, so that when I have critique to deliver, I can let the provider and other customers know. 
  _Acceptance:_
  ```gherkin
  Scenario: <Leave a review on a provider's profile>
    Given <I want to review a provider's services>
    When  <I write a review on a provider's profile>
    Then  <My review will appear on the provider's page and other customers can see it>
  ```

### 2.2 Provider Stories
- **US-5 — Register an account**  
  _Story:_ As a provider, I want to register an account, so that I can find new customers.  
  _Acceptance:_
  ```gherkin
  Scenario: Register an account.
    Given I do not have an account.
    When  I provide new account details.
    Then  I should have a registered account.
  ```

- **US-6 — Create guide services**  
  _Story:_ As a provider, I want to create services, so that customers know which locations and activities I tour.  
  _Acceptance:_
  ```gherkin
  Scenario: Creating a service
    Given I need services to begin generating customers.
    When  I provide service details.
    Then  I will have a service offered for customers.
  ```
- **US-7 — Service Statistics**  
  _Story:_ As a provider, I want to view which of my services are booked most frequently., so that I can decide where to focus effort in the future.
  _Acceptance:_
  ```gherkin
  Scenario: I need to view services to decide what to focus more time on.
    Given I have services being offered.
    When  I have performed a service and want to see how many of each.
    Then  I will view the statistics on which services are booked most frequently.
  ```
  - **US-8 — Interact with customer reviews**  
  _Story:_ As a provider, I want to interact with customer reviews, so that I can improve the guide experience.  
  _Acceptance:_
  ```gherkin
  Scenario: View and responding to customer reviews.
    Given I want customers to enjoy the experience.
    When  I view customer interaction with my services.
    Then  I will be able to respond to reviews.
  ```

---

## 3. Non‑Functional Requirements
- **Performance:** Customers appointment requests should reach their chosen guide in <3 seconds 99% of the time.
- **Availability/Reliability:** The dashboard should be viewable and updating constantly 99.5% of the time.
- **Security/Privacy:** Customer and guide accounts should be secured through security questions, and their data should enjoy the privleges of encryption.
- **Usability:** Customers and guides should be faced with an interface that is self-explanatory, and makes them proficient at using the application within 10 minutes after creating their respective accounts.

---

## 4. Assumptions, Constraints, and Policies
- Modern Browser will be used.
- Customers have knowledge of where they are looking for services. (No "suggest locations" feature planned.)
- Providers have knowledge of locations they are offering services for. (No features for provider L&D planned.)
- Compute and data retrieval will depend on 3rd party services.
- Using Render for deploy there will be a spin-up time upon server inactivity.

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues. 
- **M2 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M3 Design** — architecture, schema, API outline. 
- **M4 Backend API** — key endpoints + tests. 
- **M5 Increment** — ≥2 use cases end‑to‑end. 
- **M6 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
