DELETE FROM doctors
WHERE id NOT IN (
    SELECT DISTINCT ON (council_registry) id
    FROM doctors
    ORDER BY council_registry, created_at ASC
);

DELETE FROM doctors
WHERE id NOT IN (
    SELECT DISTINCT ON (speciality_registry) id
    FROM doctors
    ORDER BY speciality_registry, created_at ASC
);

ALTER TABLE doctors
    ADD CONSTRAINT doctors_council_registry_unique UNIQUE (council_registry);

ALTER TABLE doctors
    ADD CONSTRAINT doctors_speciality_registry_unique UNIQUE (speciality_registry);
