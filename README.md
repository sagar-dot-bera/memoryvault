# Things Done in Checkpoint One

## Project: MemoryVault

---

## Overview

In this checkpoint, the focus was on setting up the basic backend structure and implementing the first functional feature: **Memory**. The goal was to start with a simple, core use case and validate the overall design before expanding the system.

The project follows an **incremental API-first approach**, where API contracts are designed and documented first for each feature and then implemented step by step.

---

## 1. Development Approach

- Followed an **incremental API-first approach**
- API specifications are defined before implementation for each feature
- Development is done in small, manageable chunks
- Focused on correctness and clarity rather than feature completeness
- Used a layered architecture:
  - Controller
  - Service
  - Repository
  - Domain / Model

---

## 2. Memory Service

At this stage, only the **Memory** service has been implemented.  
This service represents the first complete CRUD module in the project.

### Memory Model

The memory entity includes:
- `id`
- `title`
- `description`
- `mood` (enum)
- `tags` (list of strings)
- timestamps
- reference to the owning user

### Design Decisions

- `mood` is modeled as an enum to restrict allowed values
- `tags` are stored as a list to allow flexible categorization
- Ownership checks are handled in the service layer
- The service is designed to be easily extensible

---

### Memory APIs Implemented

These APIs follow REST conventions and represent a complete CRUD flow for the Memory feature.
POST /api/memories
GET /api/memories
GET /api/memories/{id}
PUT /api/memories/{id}
DELETE /api/memories/{id}

---

## 3. API Specification

- API contracts are defined using **OpenAPI**
- The OpenAPI specification is maintained in a dedicated file
- Endpoints, request/response schemas, enums, and validation rules for the Memory feature are documented in the OpenAPI spec
- The API specification is updated incrementally as new features are added

This ensures a clear and consistent contract between the API and its implementation.

---

## 4. Generated Code

A `generated/` folder is included in the repository.

- This folder contains **auto-generated code** produced from the OpenAPI specification
- Generated code is kept separate from handwritten business logic
- Core application logic for the Memory service lives outside this folder

This separation helps keep the codebase clean and maintainable.

---

## 5. Current Status

At this checkpoint:
- One complete CRUD service (Memory) is implemented
- OpenAPI specification exists for the implemented feature
- Generated code is clearly separated from core logic
- The project structure is stable and ready for further expansion

---

## 6. Next Steps

- Add additional domain features
- Extend the OpenAPI specification incrementally
- Introduce validations and advanced querying
- Build on the existing Memory service

---




