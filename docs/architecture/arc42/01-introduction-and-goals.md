# 1. Introduction And Goals

Documentation coverage: partial

This chapter summarizes sources from the [requirements index](../../requirements/README.md). Its
statements inherit the maturity of those sources and do not become accepted through Arc42.

## 1.1 Requirements Overview

PROST supports volunteer organizations that provide shared consumable Products and account for them
through a physical paper Tally. Organization Managers issue a printable sheet, Consumers mark
consumption, and managers later settle counted marks against personal balances. Consumers inspect
their own itemized account while privileged roles manage or review the Organization.

The detailed source of truth is the [requirements index](../../requirements/README.md). The MVP
scope and exclusions are summarized in [Vision And Scope](../../requirements/vision-and-scope.md).

### Essential Capabilities

- Consumer self-registration, approval, participation lifecycle, and private account access.
- Product, printed layout, and price management.
- Preview, issuance, cancellation, and Settlement of one physical Tally.
- Exact EUR balances, manual money entries, debt suspension, and audited corrections.
- Manager administration and anonymized Treasurer aggregates.
- Self-hosted operation with provider-neutral identity and mail integration.

## 1.2 Quality Goals

| Priority | Goal                              | Meaning                                                                                                                                             |
|----------|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| 1        | Correctness and auditability      | Settlements and corrections produce exact, atomic, nonduplicated financial effects with understandable history.                                     |
| 2        | Security and privacy              | Consumers are isolated from other accounts; privileged access uses MFA; personal and financial data have explicit boundaries.                       |
| 3        | Operability                       | Volunteers can install, diagnose, back up, restore, and upgrade a self-hosted deployment without application-development knowledge.                 |
| 4        | Maintainability and extensibility | The MVP can evolve toward Organizational Units, coordinated ordering, and broader manager devices without rewriting its core accounting rules.      |
| 5        | Usability and accessibility       | Paper remains low-friction, Consumer self-service works on mobile and desktop, and manager entry is keyboard-efficient with baseline accessibility. |

Controlled quality scenarios are indexed in [section 10](10-quality-requirements.md) and maintained
with the detailed [requirements](../../requirements/README.md).

## 1.3 Stakeholders

| Stakeholder          | Architecture Expectations                                                                         |
|----------------------|---------------------------------------------------------------------------------------------------|
| Consumer             | Private, understandable, mobile-accessible account information and fair corrections.              |
| Organization Manager | Reliable Tally and account workflows with low training and operational burden.                    |
| Treasurer            | MFA-protected anonymized aggregate information without Consumer identity exposure.                |
| Deployment Operator  | Reproducible installation, secure configuration, diagnostics, backup, restore, and upgrade paths. |
| Product Owner        | Traceability from accepted requirements to architecture, implementation, and verification.        |
| Maintainer           | Clear boundaries, testable contracts, documented trade-offs, and safe change mechanisms.          |
| Potential Pilot      | Evidence that the requirements and operating model fit real volunteer work.                       |

Detailed stakeholder expectations are recorded
in [Stakeholders](../../requirements/stakeholders.md).
