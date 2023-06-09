create table project_info(
    id  VARCHAR(255) primary key not null,
    userId  VARCHAR(255),
    projectName  VARCHAR(255),
    projectContent  VARCHAR(255),
    createdBy  VARCHAR(255),
    creationDate  DATETIME,
    lastUpdatedBy  VARCHAR(255),
    lastUpdateDate  DATETIME
);