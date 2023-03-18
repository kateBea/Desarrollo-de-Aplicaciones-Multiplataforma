#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>


#define BUFFER_SIZE 128
#define QUOTE '\''

void usage(void) {
    char buffer[BUFFER_SIZE];
    sprintf(buffer, "usage: maker file_dir\n");
    write(STDOUT_FILENO, buffer, strlen(buffer));
    exit(1);
}

off_t get_file_size(int file_handle) {
    off_t backup_ptr = lseek(file_handle, 0, SEEK_CUR);
    off_t end = lseek(file_handle, 0, SEEK_END);

    lseek(file_handle, backup_ptr, SEEK_SET);
    return end;
}

char* get_data(int file_handle) {
    // retrieve current read/write pointer to restore later
    off_t backup_ptr = lseek(file_handle, 0, SEEK_CUR);

    // start reading from begining
    lseek(file_handle, 0, SEEK_SET);

    off_t file_size = get_file_size(file_handle);
    char* result = malloc(sizeof(char) * file_size);
    
    // test purposes
    printf("file size: %i\n", file_size);  
    
    if (read(file_handle, result, file_size) == -1)
        perror("failed to read from file. __get_data()...");
    

    lseek(file_handle, backup_ptr, SEEK_CUR);
    return result;
}

int main(int argc, char** argv) {
    if (argc != 2)
        usage();

    // open file with directories 
    int file_handle = open(argv[1], O_RDONLY);

    if (file_handle == -1) {
        perror("error on file opening...");
        return 1;
    }
    
    // contains all the directories
    char** directories = NULL;    
    
    // get contents from file
    char* data = get_data(file_handle);
    int file_size = get_file_size(file_handle);
    off_t index = 0;

    for (; index < file_size; ++index) {
        // read data
    }
    

    // clean-up
    free(data);

    //char arguments;
    //execvp("mkdir", "mkdir", directories);

}
