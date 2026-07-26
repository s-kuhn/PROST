---
title: Vision And Scope
status: draft
source: Product-owner interview on 2026-07-26
---

# Vision And Scope

## Problem

Volunteer organizations may provide beverages, food, or other low-value consumable products through
a shared self-service location. Consumers record consumption by making marks on a paper tally sheet.
An Organization Manager later counts those marks, charges personal balances, and records deposits or
refunds.

The current reference workflow depends on an old, narrowly tailored Django application. Consumers
cannot inspect their account directly, operational knowledge is concentrated in a few volunteers,
and the legacy implementation is not a suitable foundation for broader capabilities.

## Product Vision

PROST enables a volunteer organization to operate a transparent, auditable, and self-hosted
paper-tally workflow without making each consumption depend on a digital device.

## Business Goals

Ordered by priority:

1. Replace the legacy workflow safely without losing financial correctness.
2. Preserve the low-friction physical tally sheet at the point of consumption.
3. Give Consumers transparent access to their own balance and transaction history.
4. Allow volunteers to host and operate the system without an institution-specific service
   dependency.
5. Provide a maintainable foundation for future organizational units, procurement, inventory, and
   reporting.

## MVP Scope

The MVP supports one Organization, one tally location, one Tally in Issued or Settlement Draft state
at a time, up to 50 Consumers, and approximately two to ten active Products. It provides:

- self-registration, verified email, profile completion, and manager approval;
- Consumer lifecycle and role management;
- Product and printed-layout management;
- A3 landscape PDF preview and issuance;
- physical-sheet settlement with itemized account charges;
- deposits, refunds, adjustments, debt suspension, and audited corrections;
- private Consumer balance and transaction views;
- anonymized aggregate views for Treasurers;
- German and English browser UI;
- public HTTPS and explicitly insecure private-network HTTP deployment modes;
- provider-neutral local identity plus optional OIDC federation;
- documented backup, restore, and self-hosting procedures.

## MVP Non-Goals

- Digital recording of each consumption.
- OCR or automatic interpretation of sheet photographs.
- Inventory, purchasing, supplier integration, or invoices.
- Organizational Units or coordinated ordering.
- Organization balance accounting based on Consumer Deposits and supplier invoices.
- Internal or external sales price calculation.
- Calculation for goods exchange between Organizations.
- Detailed operational reporting beyond the MVP anonymized aggregates.
- Native mobile applications.
- Balance reminder emails.
- Automatic payment-provider confirmation.
- Legacy data migration.
- CSV or bookkeeping export.
- Multiple simultaneous tally locations.

## Success Definition

The MVP is functionally successful when a pilot Organization can complete an end-to-end cycle from
Consumer registration through Tally issuance, Settlement, balance inspection, payment recording, and
correction without using the legacy application.

## Validation Risk

The current source is prior operational experience. A potential pilot exists, but stakeholder access
and acceptance sessions are not yet committed. Requirements remain draft until reviewed with the
product owner and, where possible, pilot users.
