DELETE FROM patients
WHERE id NOT IN (
    SELECT DISTINCT ON (phone_number) id
FROM patients
ORDER BY phone_number, created_at ASC
    );

ALTER TABLE patients
    ADD CONSTRAINT phone_number_unique UNIQUE (phone_number);
