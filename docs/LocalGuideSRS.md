
# Requirements – Starter Template

**Project Name:** Your App Name \
**Team:** Names and roles \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-08-25

---

## 1. Overview
**Vision.** One or two sentences: who this is for, the core problem, and the outcome.

**Glossary** Terms used in the project
- **Term 1:** description.
- **Term 2:** description

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — 1 line goal statement.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.
- **SysAdmin (optional)** — 1 line goal statement.

**Scope (this semester).**
- <capability 1>
- <capability 2>
- <capability 3>

**Out of scope (deferred).**
- <deferred 1>
- <deferred 2>

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑1 — <Register an accout>**  
  _Story:_ As a customer, I want to register an account so that I can utilize the services provided.
  _Acceptance:_
  ```gherkin
  Scenario: <Register with email>
    Given <I do not already have an account>
    When  <I provide a valid email>
    Then  <I should have an account and profile>
    And   <Utilize the app's services>
  ```

- **US‑2 — <View available services>**  
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
- **US-20 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US-21 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US‑30 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑31 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

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
