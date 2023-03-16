#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>


#define BUFFER_SIZE 128

void usage(void) {
    char buffer[BUFFER_SIZE];
    sprintf(buffer, "usage: maker file_dir\n");
    write(STDOUT_FILENO, buffer, strlen(buffer));
    exit(1);
}

int total_directories(int file_handle) {
    off_t backyup = lseek(file_handle, 0, SEEK_CUR);

    off_t begin = lseek(file_handle, 0, SEEK_SET);
    off_t end = lseek(file_handle, 0, SEEK_END);

    lseek(file_handle, backyup, SEEK_SET);

    return end - begin;

}

char* get_data(int file_handle, int size)  {
    char* ret_ptr = malloc(sizeof(char) * size);

    // bakckup read/write ptr
    off_t backup = lseek(file_handle, 0, SEEK_CUR);

    // start read from beginning
    lseek(file_handle, 0, SEEK_SET);
    read(file_handle, ret_ptr, size);

    // restore read/write ptr
    lseek(file_handle, backup, SEEK_SET);

    return ret_ptr;
}
int main(int argc, char** argv) {
    if (argc != 2)
        usage();

    // open file with with directories 
    int file_handle = open(argv[1], O_RDONLY);

    if (file_handle == -1) {
        perror("error on file opening...");
        return 1;
    }

    // read directories (we don't know total amount of 
    // directories prior to reading the file)

    printf("file size: %d\n", total_directories(file_handle));

    // we assume all directories are separated by '\n'
    char** directories = malloc(total_directories(file_handle) * sizeof(char*));
    char* data = get_data(file_handle, total_directories(file_handle));

    int index = 0;
    int path_size = 0;

    perror("reached");  
    for (int i = 0; i < total_directories(file_handle); ++i)
        printf("byte: %d\n", data[i]);
    
    for (; index < total_directories(file_handle) - 1; ++index) {
        
        int buffer_index = 0;
        while (1) {
            if (*(data + (buffer_index + 1)) == '\n')
                break;
            else 
                ++buffer_index;
        }

        // alloc memory for size of path + null terminating character
        directories[index] = malloc(sizeof(char) * buffer_index + 2);
        memcpy(directories[index], data, buffer_index + 1);

        directories[index][buffer_index + 1] = '\0';
    }

    printf("%s\n", directories[0]);
    printf("%s\n", directories[1]);

    // clean-up
    free(data);

    //char arguments;
    //execvp("mkdir", "mkdir", directories);

}