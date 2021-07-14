## Part 1: Test it with SQL
SHOW FIELDS FROM job;
## Part 2: Test it with SQL
SELECT * FROM techjobs.employer where location = 'St. Louis City';
## Part 3: Test it with SQL
Drop Table techjobs.job;
## Part 4: Test it with SQL
select s.name , s.description from techjobs.job_skills js
join techjobs.skill s on s.id = js.skills_id
order by s.name