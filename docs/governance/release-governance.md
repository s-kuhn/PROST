---
title: Release Governance
status: accepted
source: Product-owner decisions resolving OQ-011 on 2026-07-30
---

# Release Governance

No release may be published until the release process verifies all of the following against the
[Licensing And Copyright](licensing.md) policy:

- the repository and release artifacts identify software as `AGPL-3.0-or-later`;
- original documentation is identified as `CC-BY-SA-4.0`;
- the standard license texts accompany the applicable material;
- the copyright notice and SPDX metadata are consistent with the material they cover;
- third-party licenses, copyright notices, and attribution requirements are preserved;
- dependency and bundled-asset license compatibility has been reviewed;
- generated files and existing versioned migrations have not been edited merely to add notices;
- source availability and notices required by AGPL network use and distribution are present;
- release notes identify any licensing transition that affects the released revision.

The automated REUSE/SPDX compliance check must pass. Automation does not replace review of
third-party license compatibility or provenance.
