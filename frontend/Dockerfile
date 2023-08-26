# Use an official Node runtime as the base image
FROM node:14

# Set the working directory within the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install application dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the React application
RUN npm run build

# Expose the port that the application will run on
EXPOSE 80

# Command to run the application
CMD [ "npm", "start" ]
