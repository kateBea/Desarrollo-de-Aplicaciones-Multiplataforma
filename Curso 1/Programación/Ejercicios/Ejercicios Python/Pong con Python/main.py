# Pong Juego
# Algoritmo: Juego de pong
# Fecha: 12.2.2022
# Auor: Hugo Pelayo

if __name__ == "__main__":
    # imports
    import pygame
    import sys

    # initialize pygame and system utils
    pygame.init()
    clock = pygame.time.Clock()

    # window size and other constants
    WIN_WIDTH   = 720
    WIN_HEIGHT  = 480
    RATE = 60

    PLAYER_PIXEL_WIDTH  = 10
    PLAYER_PIXEL_HEIGHT = 140
    BALL_SIZE           = 30

    ball = pygame.Rect(WIN_WIDTH - 180, WIN_HEIGHT / 2 - 15, BALL_SIZE, BALL_SIZE)
    player1 = pygame.Rect(WIN_WIDTH / 20, WIN_HEIGHT / 2 + 225, PLAYER_PIXEL_HEIGHT, PLAYER_PIXEL_WIDTH)

    ball_speed_x = 7
    ball_speed_y = 7
    player_speed = 0

    bg_color    = pygame.Color('grey12')
    light_grey  = (200, 200, 200)

    def animation():
        global ball_speed_x, ball_speed_y
        global player_speed, RATE

        screen_delimiter = 0.81

        ball.x += ball_speed_x
        ball.y += ball_speed_y

        player1.x += player_speed
        if player1.left <= 0:
            player1.x = 0
        if player1.right >= WIN_WIDTH:
            player1.x = WIN_WIDTH * screen_delimiter

        # bounce when hitting screen bounds
        if ball.top <= 0 or ball.bottom >= WIN_HEIGHT:
            ball_speed_y *= -1
        if ball.left <= 0 or ball.right >= WIN_WIDTH:
            ball_speed_x *= -1

        # bounce when colliding with player
        if ball.colliderect(player1):
            ball_speed_x *= -1
            if RATE <= 120:
                RATE += 1

    # main window setup
    window = pygame.display.set_mode((WIN_WIDTH, WIN_HEIGHT))
    pygame.display.set_caption('Pong Game')

    while True:
        # input handler
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RIGHT:
                    player_speed += 7
                if event.key == pygame.K_LEFT:
                    player_speed -= 7
            if event.type == pygame.KEYUP:
                if event.key == pygame.K_RIGHT:
                    player_speed -= 7
                if event.key == pygame.K_LEFT:
                    player_speed += 7

        animation()

        # draw game elements to screen
        window.fill(bg_color)
        pygame.draw.rect(window, light_grey, player1)
        pygame.draw.ellipse(window, light_grey, ball)

        # refresh display contents
        pygame.display.flip()
        # limit refresh rate
        clock.tick(RATE)